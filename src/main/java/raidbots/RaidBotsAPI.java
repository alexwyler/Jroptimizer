package raidbots;

import com.alexwyler.jurl.Jurl;
import raidbots.objects.*;
import raidbots.objects.Character;

import java.util.Arrays;

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

    public static SSimResponse droptimizerDazarAlor(String realm, String name) {
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

        //"frontendHost":"www.raidbots.com",
        //"frontendVersion":"aba583abfe41d91dd7e64bb825991109f477ccaf"

        Jurl jurl = getBaseJurl()
                .url(String.format("https://www.raidbots.com/sim"))
                .method("POST")
                .bodyJson(simRequest);
        jurl.go();
        return jurl.getResponseJsonObject(SSimResponse.class);
    }

    public static SSimStatus checkSimStatus(String simId) {
        return getBaseJurl()
                .url(String.format(String.format("https://www.raidbots.com/api/job/%s", simId)))
                .method("GET")
                .go()
                .getResponseJsonObject(SSimStatus.class);
    }

//    public static SSimData loadCompletedSimData(String simId) {
//        return getBaseJurl()
//                .url(String.format("https://www.raidbots.com/reports/%s/data.json", simId))
//                .method("GET")
//                .go()
//                .getResponseJsonObject()
//    }
//
//    public static Callable<>
}
