import battlenet.BattleNetApi;
import battlenet.objects.SGuild;
import raidbots.RaidBotsAPI;
import raidbots.objects.SInstance;
import raidbots.objects.SItem;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Created by alexwyler on 2/15/19.
 */
public class Main {

    public static void main(String args[]) throws IOException, ExecutionException, InterruptedException {

        SGuild guild = BattleNetApi.getGuildMembers("Lightbringer", "Resident Kabuki Theatre");
        List<SGuild.SMemberCharacter> raiders = guild.members.stream().filter(m -> Arrays.asList(0l, 1l, 4l).contains(m.rank) && m.character.level == 120l).map(m -> m.character).collect(Collectors.toList());

        raiders = new ArrayList<>(raiders.subList(0, 3));
        ExecutorService                 service  = Executors.newFixedThreadPool(8);
        Map<String, Future<List<SItem>>> upgradeFutures = new HashMap<>();
        for (SGuild.SMemberCharacter raider : raiders) {
            upgradeFutures.put(raider.name, service.submit(RaidBotsAPI.selectBetterItemsCallable("Lightbringer", raider.name)));
        }

        for (String raider : upgradeFutures.keySet()) {
            List<SItem> upgrades = upgradeFutures.get(raider).get();
            System.out.println(raider + ":");
            for (SItem upgrade : upgrades) {
                System.out.println(upgrade.name + " - " + SInstance.getEncounter(upgrade.sources.get(0).encounterId).name);
            }
            System.out.println("");
        }


    }
}
