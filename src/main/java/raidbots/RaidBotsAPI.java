package raidbots;

import com.alexwyler.jurl.Jurl;
import raidbots.objects.*;
import raidbots.objects.Character;
import util.JacksonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                .url(String.format("https://www.raidbots.com/wowapi/character/us/%s/%s", realm, name))
                .method("GET");
        return jurl.go()
                .getResponseJsonObject(Character.class);
    }

    public static SSimResponse beginDroptimizer(String realm, String name) {
        Character character = fetch(realm, name);
        Items equipped = character.getItems();
        String spec = character.getTalents().get(0).getSpec().getName();

        Droptimizer droptimizer = new Droptimizer();
        droptimizer.setEquipped(equipped);
        // Battle for Dazar'Alor
        droptimizer.setInstances(Arrays.asList(1176l));
        droptimizer.setDifficulty("raid-mythic");
        droptimizer.setFaction(character.getFaction() == 0 ? "alliance" : "horde");

        SSimRequest simRequest = new SSimRequest();
        simRequest.setType("droptimizer");
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

        Jurl jurl = getBaseJurl()
                .url(String.format("https://www.raidbots.com/sim"))
                .method("POST")
                .bodyJson(simRequest);

        System.out.println(jurl.toCurl());
        jurl.go();
        return jurl.getResponseJsonObject(SSimResponse.class);
    }

    public static List<String> selectBetterItems(String realm, String character) {
        SSimResponse simResponse = beginDroptimizer(realm, character);
        return selectBetterItems(simResponse.getSimId());
    }

    public static List<String> selectBetterItems(String simId) {
        Callable<SSimData> callable = responsiblyWaitingCallable(simId);
        List<String> betterItems = new ArrayList<>();
        try {
            SSimData data = callable.call();
            System.out.println(JacksonUtil.writePretty(data));
            double preDPS = data.sim.players.get(0).collected_data.dpse.mean;
            for (SSimData.SProfileSetResult result : data.sim.profilesets.results) {
                if  (result.mean > preDPS) {
                    betterItems.add(result.name);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return betterItems;
    }

    public static SSimStatus checkSimStatus(String simId) {
        return getBaseJurl()
                .url(String.format(String.format("https://www.raidbots.com/api/job/%s", simId)))
                .method("GET")
                .go()
                .getResponseJsonObject(SSimStatus.class);
    }

    public static SSimData loadCompletedSimData(String simId) {
        Jurl jurl = getBaseJurl()
                .url(String.format("https://www.raidbots.com/reports/%s/data.json", simId))
                .method("GET")
                .go();

        System.out.println(jurl.getResponseBody());
        return jurl
                .getResponseJsonObject(SSimData.class);
    }

    public static Callable<SSimData> responsiblyWaitingCallable(final String simId) {
        return () -> {
            while (true) {
                SSimStatus sSimStatus = checkSimStatus(simId);
                if ("complete".equals(sSimStatus.getJob().getState())) {
                    break;
                } else {
                    System.out.println(simId);
                    System.out.println(JacksonUtil.writePretty(sSimStatus.getQueue()));
                    System.out.println(sSimStatus.getLog());
                    Thread.sleep(30_000);
                }
            }
            return loadCompletedSimData(simId);
        };
    }

    public static void main(String args[]) {
        System.out.println(selectBetterItems("Lightbringer", "Sunkin"));
        //System.out.println(selectBetterItems("eZSapoc1QUWMRJWWqBQoWm"));
    }
}
