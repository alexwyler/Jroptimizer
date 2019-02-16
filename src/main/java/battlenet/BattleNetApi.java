package battlenet;

import battlenet.objects.SGuild;
import com.alexwyler.jurl.Jurl;
import util.CachedValue;

/**
 * Created by alexwyler on 2/15/19.
 */
public class BattleNetApi {

    public static String clientId     = System.getenv("BATTLE_NET_ID");
    public static String clientSecret = System.getenv("BATTLE_NET_SECRET");

    private static CachedValue<String> CACHED_ACCESS_TOKEN = new CachedValue<>(43_200_000, () -> generateOauthAccessToken());

    public static String generateOauthAccessToken() {
        Jurl jurl = new Jurl()
                .basicHttpAuth(clientId, clientSecret)
                .url("https://us.battle.net/oauth/token")
                .param("grant_type", "client_credentials");

        jurl.go();

        return jurl.getResponseJsonObject(SAccessTokenResponse.class).access_token;
    }


    public static SGuild getGuildMembers(String realm, String guildName) {
        Jurl jurl;
        jurl = new Jurl()
            .method("GET")
            .url(String.format("https://us.api.blizzard.com/wow/guild/%s/%s", realm, guildName.replaceAll("\\s","%20")))
            .param("access_token", CACHED_ACCESS_TOKEN.get())
            .param("fields", "members")
            .param("locale", "en_US");

        jurl.go();
        return jurl.getResponseJsonObject(SGuild.class);
    }

    public static class SAccessTokenResponse {
        public String access_token;
        public String token_type;
        public Long   expires_in;
    }

}
