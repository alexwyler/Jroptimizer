package raidbots;

import com.alexwyler.jurl.Jurl;
import org.apache.commons.lang3.StringUtils;
import raidbots.objects.*;
import raidbots.objects.Character;
import util.CachedValue;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by alexwyler on 2/13/19.
 */
public class RaidBotsAPI {

    public static Jurl getBaseJurl() {
        Jurl jurl = new Jurl()
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.96 Safari/537.36")
                .header("Referer", "https://www.raidbots.com/simbot/droptimizer")
                .header("Accept", "application/json, text/plain, */*")
                .header("Origin", "https://www.raidbots.com")
                .header("Content-Type", "application/json")
                .throwOnNon200(true);
        return jurl;
    }

    public static Character fetch(String realm, String name) {
        Jurl jurl = getBaseJurl()
                .url(String.format("https://www.raidbots.com/wowapi/character/us/%s/%s", StringUtils.lowerCase(realm), name))
                .method("GET");
        return jurl.go()
                .getResponseJsonObject(Character.class);
    }

    private static CachedValue<String> CACHED_RAIDS_ID = new CachedValue<>(60_000, () -> getAuthenticatedRaidsId());

    public static String getAuthenticatedRaidsId() {
        Map<String, String> loginRequest = new HashMap<>();

        String raidbotsEmail = System.getenv("RAIDBOTS_EMAIL");
        String raidBotsPassword = System.getenv("RAIDBOTS_PASSWORD");
        if (raidbotsEmail != null && raidBotsPassword != null) {
            loginRequest.put("email", raidbotsEmail);
            loginRequest.put("password", raidBotsPassword.trim());

            Jurl jurl = getBaseJurl()
                    .url("https://www.raidbots.com/api/login")
                    .method("POST")
                    .bodyJson(loginRequest);

            return jurl.go().getResponseCookie("raidsid").getValue();
        } else {
            return null;
        }
    }

    public static Jurl getAuthenticatedJurl() {
        Jurl jurl = getBaseJurl();

        String raidsId = CACHED_RAIDS_ID.get();
        if (raidsId != null) {
             jurl.cookie("raidsid", raidsId);
        }
        return jurl;
    }

    public static SSimResponse beginDroptimizer(String realm, String name) {
        Character character = fetch(realm, name);
        character.setChanged(false);
        character.setNextRelicId(1l);

        Items equipped = character.getItems();
        equipped.setAverageItemLevel(null);
        equipped.setAverageItemLevelEquipped(null);
        String spec = character.getTalents().get(0).getSpec().getName();

        Droptimizer droptimizer = new Droptimizer();
        droptimizer.setEquipped(equipped);
        // Battle for Dazar'Alor
        droptimizer.setInstances(Arrays.asList(1176l));
        droptimizer.setDifficulty("raid-mythic");
        droptimizer.setFaction(character.getFaction() == 0 ? "alliance" : "horde");
        droptimizer.setClassId(character.getClass_());
        droptimizer.setSpecId(RBCharacterInfo.specIdForName(RBCharacterInfo.classNameForId(character.getClass_()), spec));

        SSimRequest simRequest = new SSimRequest();
        simRequest.setType("droptimizer");
        simRequest.setApl("");
        simRequest.setEmail("");
        simRequest.setFlask("");
        simRequest.setFood("");
        simRequest.setFrontendHost("www.raidbots.com");
        // TODO
        //simRequest.setFrontendVersion("916c2b29dd212ed8ef577667a00b3b60f56327d2");
        simRequest.setIterations("smart");
        simRequest.setPantheonTrinkets(0l);
        simRequest.setPotion("");
        simRequest.setReoriginationArray(0l);
        simRequest.setSendEmail(false);
        simRequest.setSimcItems(new SimcItems());
        simRequest.setTalents(null);
        simRequest.setText("");

        simRequest.setAugmentation("");
        simRequest.setBaseActorName(name);
        simRequest.setSpec(spec);
        simRequest.setReportName("Droptimizer - Battle of Dazar'alor - Mythic");
        simRequest.setArmory(new Armory("us", realm, name));
        simRequest.setCharacter(character);
        simRequest.setSimcVersion("nightly");
        simRequest.setSmartHighPrecision(false);
        simRequest.setFightStyle("Patchwerk");
        simRequest.setFightLength(300l);
        simRequest.setEnemyCount(1l);
        simRequest.setEnemyType("FluffyPillow");
        simRequest.setBloodlust(true);
        simRequest.setArcaneIntellect(true);
        simRequest.setFortitude(true);
        simRequest.setBattleShout(true);
        simRequest.setMysticTouch(true);
        simRequest.setChaosBrand(true);
        simRequest.setBleeding(true);
        simRequest.setReportDetails(true);
        simRequest.setZuldazar(true);
        simRequest.setCovenantChance(100l);
        simRequest.setPtr(false);
        simRequest.setMysticTouch(true);
        simRequest.setMysticTouch(true);
        simRequest.setDroptimizer(droptimizer);
        simRequest.setDroptimizer(droptimizer);

        Jurl jurl = getAuthenticatedJurl()
                .url(String.format("https://www.raidbots.com/sim"))
                .method("POST")
                .bodyJson(simRequest);
        jurl.go();
        return jurl.getResponseJsonObject(SSimResponse.class);
    }

    public static Callable<List<SItem>> selectBetterItemsCallable(String realm, String character) {
        return () -> {
            System.out.println(String.format("Running Raidbots' Droptimizer for %s-%s...", character, realm));
            SSimResponse simResponse = beginDroptimizer(realm, character);
            return selectBetterItemsFromSimCallable(simResponse.getSimId(), character).call();
        };
    }

    private static Callable<List<SItem>> selectBetterItemsFromSimCallable(String simId, String name) {
        return () -> {
            Callable<SSimData> callable = responsiblyWaitingCallable(simId, name);
            List<SItem> betterItems = new ArrayList<>();
            try {
                SSimData data = callable.call();
                if (data != null && data.sim != null && data.sim.players != null && !data.sim.players.isEmpty()) {
                    double preDPS = data.sim.players.get(0).collected_data.dpse.mean;
                    for (SSimData.SProfileSetResult result : data.sim.profilesets.results) {
                        if (result.mean > preDPS) {
                            long itemId = Long.parseLong(result.name.split("/")[2]);
                            betterItems.add(SItem.getItem(itemId));
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return betterItems;
        };

    }

    public static SSimStatus checkSimStatus(String simId) {
        return getAuthenticatedJurl()
                .url(String.format(String.format("https://www.raidbots.com/api/job/%s", simId)))
                .method("GET")
                .go()
                .getResponseJsonObject(SSimStatus.class);
    }

    public static SSimData loadCompletedSimData(String simId) {
        Jurl jurl = getAuthenticatedJurl()
                .url(String.format("https://www.raidbots.com/reports/%s/data.json", simId))
                .method("GET")
                .go();

        return jurl
                .getResponseJsonObject(SSimData.class);
    }

    private static final String SIM_STATUS_OUTPUT_FORMAT = "%-8.12s [%-22.22s] - %-8.8s(%-2.3s)\n";

    public static Callable<SSimData> responsiblyWaitingCallable(final String simId, String name) {
        return () -> {
            while (true) {
                SSimStatus sSimStatus = checkSimStatus(simId);
                if ("complete".equals(sSimStatus.getJob().getState())) {
                    break;
                } else {
                    long progress = sSimStatus.getJob().getProgress();
                    System.out.printf(SIM_STATUS_OUTPUT_FORMAT, name, simId, sSimStatus.getJob().getState(), progress + "%");
                    long sleep = ((100 - progress) / 100) * 45_000 + 4_000;
                    Thread.sleep(sleep);
                }
            }
            return loadCompletedSimData(simId);
        };
    }

}
