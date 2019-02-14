import util.JacksonUtil;
import raidbots.RaidBotsAPI;

/**
 * Created by alexwyler on 2/13/19.
 */
public class Main {


    public static void main(String args[]) {
        System.out.println(JacksonUtil.writePretty(RaidBotsAPI.droptimizerDazarAlor("Lightbringer", "Sunkin")));
    }
}
