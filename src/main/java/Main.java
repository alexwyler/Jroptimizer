import ca.forklabs.wow.net.AuthenticatedBNetConnection;
import ca.forklabs.wow.net.BNetConnection;
import ca.forklabs.wow.net.Region;
import ca.forklabs.wow.net.WoWAPI;

import java.io.IOException;

/**
 * Created by alexwyler on 2/15/19.
 */
public class Main {

    public static void main(String args[]) throws IOException {
        String public_key = "public_key"; // your own public key here
        String private_key = "private_key"; // your own private key here
        BNetConnection connection = new AuthenticatedBNetConnection(public_key, private_key);

        WoWAPI api = new WoWAPI();
        api.setBNetConnection(connection);

        Region region = Region.Americas;
        String realm = "Skullcrusher";
        String name = "Oscassey";
        WoWAPI.Answer answer = api.getCharacter(region, realm, name);

        System.out.println("HTTP code: " + answer.code); System.out.println(answer.json);
    }
}
