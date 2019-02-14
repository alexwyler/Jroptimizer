package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "realm",
        "battlegroup",
        "members",
        "achievementPoints",
        "emblem"
})
public class Guild {

    @JsonProperty("name")
    private String name;
    @JsonProperty("realm")
    private String realm;
    @JsonProperty("battlegroup")
    private String battlegroup;
    @JsonProperty("members")
    private Long   members;
    @JsonProperty("achievementPoints")
    private Long   achievementPoints;
    @JsonProperty("emblem")
    private Emblem emblem;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("realm")
    public String getRealm() {
        return realm;
    }

    @JsonProperty("realm")
    public void setRealm(String realm) {
        this.realm = realm;
    }

    @JsonProperty("battlegroup")
    public String getBattlegroup() {
        return battlegroup;
    }

    @JsonProperty("battlegroup")
    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    @JsonProperty("members")
    public Long getMembers() {
        return members;
    }

    @JsonProperty("members")
    public void setMembers(Long members) {
        this.members = members;
    }

    @JsonProperty("achievementPoints")
    public Long getAchievementPoints() {
        return achievementPoints;
    }

    @JsonProperty("achievementPoints")
    public void setAchievementPoints(Long achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    @JsonProperty("emblem")
    public Emblem getEmblem() {
        return emblem;
    }

    @JsonProperty("emblem")
    public void setEmblem(Emblem emblem) {
        this.emblem = emblem;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
