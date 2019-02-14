package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "lastModified",
        "name",
        "realm",
        "battlegroup",
        "class",
        "race",
        "gender",
        "level",
        "achievementPoints",
        "thumbnail",
        "calcClass",
        "faction",
        "guild",
        "items",
        "talents",
        "totalHonorableKills",
        "changed",
        "nextRelicId"
})
public class Character {

    @JsonProperty("lastModified")
    private Long   lastModified;
    @JsonProperty("name")
    private String name;
    @JsonProperty("realm")
    private String realm;
    @JsonProperty("battlegroup")
    private String battlegroup;
    @JsonProperty("class")
    private Long   _class;
    @JsonProperty("race")
    private Long   race;
    @JsonProperty("gender")
    private Long   gender;
    @JsonProperty("level")
    private Long   level;
    @JsonProperty("achievementPoints")
    private Long   achievementPoints;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("calcClass")
    private String calcClass;
    @JsonProperty("faction")
    private Long   faction;
    @JsonProperty("guild")
    private Guild  guild;
    @JsonProperty("items")
    private Items  items;
    @JsonProperty("talents")
    private List<Talent> talents = new ArrayList<Talent>();
    @JsonProperty("totalHonorableKills")
    private Long    totalHonorableKills;
    @JsonProperty("changed")
    private Boolean changed;
    @JsonProperty("nextRelicId")
    private Long    nextRelicId;

    /**
     * No args constructor for use in serialization
     */
    public Character() {
    }

    /**
     * @param lastModified
     * @param talents
     * @param faction
     * @param race
     * @param changed
     * @param totalHonorableKills
     * @param _class
     * @param level
     * @param thumbnail
     * @param battlegroup
     * @param achievementPoints
     * @param items
     * @param realm
     * @param nextRelicId
     * @param name
     * @param gender
     * @param calcClass
     * @param guild
     */
    public Character(Long lastModified, String name, String realm, String battlegroup, Long _class, Long race, Long gender, Long level, Long achievementPoints, String thumbnail, String calcClass, Long faction, Guild guild, Items items, List<Talent> talents, Long totalHonorableKills, Boolean changed, Long nextRelicId) {
        super();
        this.lastModified = lastModified;
        this.name = name;
        this.realm = realm;
        this.battlegroup = battlegroup;
        this._class = _class;
        this.race = race;
        this.gender = gender;
        this.level = level;
        this.achievementPoints = achievementPoints;
        this.thumbnail = thumbnail;
        this.calcClass = calcClass;
        this.faction = faction;
        this.guild = guild;
        this.items = items;
        this.talents = talents;
        this.totalHonorableKills = totalHonorableKills;
        this.changed = changed;
        this.nextRelicId = nextRelicId;
    }

    @JsonProperty("lastModified")
    public Long getLastModified() {
        return lastModified;
    }

    @JsonProperty("lastModified")
    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

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

    @JsonProperty("class")
    public Long getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(Long _class) {
        this._class = _class;
    }

    @JsonProperty("race")
    public Long getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(Long race) {
        this.race = race;
    }

    @JsonProperty("gender")
    public Long getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Long gender) {
        this.gender = gender;
    }

    @JsonProperty("level")
    public Long getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Long level) {
        this.level = level;
    }

    @JsonProperty("achievementPoints")
    public Long getAchievementPoints() {
        return achievementPoints;
    }

    @JsonProperty("achievementPoints")
    public void setAchievementPoints(Long achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("calcClass")
    public String getCalcClass() {
        return calcClass;
    }

    @JsonProperty("calcClass")
    public void setCalcClass(String calcClass) {
        this.calcClass = calcClass;
    }

    @JsonProperty("faction")
    public Long getFaction() {
        return faction;
    }

    @JsonProperty("faction")
    public void setFaction(Long faction) {
        this.faction = faction;
    }

    @JsonProperty("guild")
    public Guild getGuild() {
        return guild;
    }

    @JsonProperty("guild")
    public void setGuild(Guild guild) {
        this.guild = guild;
    }

    @JsonProperty("items")
    public Items getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items items) {
        this.items = items;
    }

    @JsonProperty("talents")
    public List<Talent> getTalents() {
        return talents;
    }

    @JsonProperty("talents")
    public void setTalents(List<Talent> talents) {
        this.talents = talents;
    }

    @JsonProperty("totalHonorableKills")
    public Long getTotalHonorableKills() {
        return totalHonorableKills;
    }

    @JsonProperty("totalHonorableKills")
    public void setTotalHonorableKills(Long totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }

    @JsonProperty("changed")
    public Boolean getChanged() {
        return changed;
    }

    @JsonProperty("changed")
    public void setChanged(Boolean changed) {
        this.changed = changed;
    }

    @JsonProperty("nextRelicId")
    public Long getNextRelicId() {
        return nextRelicId;
    }

    @JsonProperty("nextRelicId")
    public void setNextRelicId(Long nextRelicId) {
        this.nextRelicId = nextRelicId;
    }

}
