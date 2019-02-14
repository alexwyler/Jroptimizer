
package raidbots.objects;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "title",
    "type",
    "player",
    "charClass",
    "spec",
    "fightStyle",
    "simcVersion"
})
public class Meta {

    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonProperty("player")
    private String player;
    @JsonProperty("charClass")
    private String charClass;
    @JsonProperty("spec")
    private String spec;
    @JsonProperty("fightStyle")
    private String fightStyle;
    @JsonProperty("simcVersion")
    private String simcVersion;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param spec
     * @param title
     * @param player
     * @param simcVersion
     * @param charClass
     * @param type
     * @param fightStyle
     */
    public Meta(String title, String type, String player, String charClass, String spec, String fightStyle, String simcVersion) {
        super();
        this.title = title;
        this.type = type;
        this.player = player;
        this.charClass = charClass;
        this.spec = spec;
        this.fightStyle = fightStyle;
        this.simcVersion = simcVersion;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("player")
    public String getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(String player) {
        this.player = player;
    }

    @JsonProperty("charClass")
    public String getCharClass() {
        return charClass;
    }

    @JsonProperty("charClass")
    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    @JsonProperty("spec")
    public String getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(String spec) {
        this.spec = spec;
    }

    @JsonProperty("fightStyle")
    public String getFightStyle() {
        return fightStyle;
    }

    @JsonProperty("fightStyle")
    public void setFightStyle(String fightStyle) {
        this.fightStyle = fightStyle;
    }

    @JsonProperty("simcVersion")
    public String getSimcVersion() {
        return simcVersion;
    }

    @JsonProperty("simcVersion")
    public void setSimcVersion(String simcVersion) {
        this.simcVersion = simcVersion;
    }

}
