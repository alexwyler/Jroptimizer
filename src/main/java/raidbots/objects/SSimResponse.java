
package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "jobId",
    "simId",
    "simcVersion",
    "title",
    "type",
    "source",
    "origin",
    "player",
    "faction",
    "class",
    "race",
    "spec",
    "role",
    "iterations",
    "totalIterations",
    "smartHighPrecision",
    "fightStyle",
    "fightLength",
    "potion",
    "food",
    "flask",
    "augmentation",
    "optimalRaid",
    "bloodlust",
    "arcaneIntellect",
    "fortitude",
    "battleShout",
    "mysticTouch",
    "chaosBrand",
    "reoriginationArray",
    "bleeding",
    "reportDetails",
    "enemyCount",
    "enemyType",
    "created",
    "frontendVersion",
    "skipEnabled"
})
public class SSimResponse {

    @JsonProperty("jobId")
    private Long jobId;
    @JsonProperty("simId")
    private String simId;
    @JsonProperty("simcVersion")
    private String simcVersion;
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonProperty("source")
    private String source;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("player")
    private String player;
    @JsonProperty("faction")
    private String faction;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("race")
    private String race;
    @JsonProperty("spec")
    private String spec;
    @JsonProperty("role")
    private String role;
    @JsonProperty("iterations")
    private String iterations;
    @JsonProperty("totalIterations")
    private Long totalIterations;
    @JsonProperty("smartHighPrecision")
    private Boolean smartHighPrecision;
    @JsonProperty("fightStyle")
    private String fightStyle;
    @JsonProperty("fightLength")
    private Long fightLength;
    @JsonProperty("potion")
    private String potion;
    @JsonProperty("food")
    private String food;
    @JsonProperty("flask")
    private String flask;
    @JsonProperty("augmentation")
    private String augmentation;
    @JsonProperty("optimalRaid")
    private Boolean optimalRaid;
    @JsonProperty("bloodlust")
    private Boolean bloodlust;
    @JsonProperty("arcaneIntellect")
    private Boolean arcaneIntellect;
    @JsonProperty("fortitude")
    private Boolean fortitude;
    @JsonProperty("battleShout")
    private Boolean battleShout;
    @JsonProperty("mysticTouch")
    private Boolean mysticTouch;
    @JsonProperty("chaosBrand")
    private Boolean chaosBrand;
    @JsonProperty("reoriginationArray")
    private Long reoriginationArray;
    @JsonProperty("bleeding")
    private Boolean bleeding;
    @JsonProperty("reportDetails")
    private Boolean reportDetails;
    @JsonProperty("enemyCount")
    private Long enemyCount;
    @JsonProperty("enemyType")
    private String enemyType;
    @JsonProperty("created")
    private String created;
    @JsonProperty("frontendVersion")
    private String frontendVersion;
    @JsonProperty("skipEnabled")
    private Boolean skipEnabled;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SSimResponse() {
    }

    /**
     * 
     * @param spec
     * @param flask
     * @param fortitude
     * @param player
     * @param jobId
     * @param totalIterations
     * @param faction
     * @param type
     * @param race
     * @param title
     * @param augmentation
     * @param frontendVersion
     * @param created
     * @param potion
     * @param role
     * @param fightStyle
     * @param arcaneIntellect
     * @param fightLength
     * @param smartHighPrecision
     * @param reoriginationArray
     * @param iterations
     * @param mysticTouch
     * @param origin
     * @param enemyType
     * @param chaosBrand
     * @param optimalRaid
     * @param simId
     * @param skipEnabled
     * @param enemyCount
     * @param reportDetails
     * @param battleShout
     * @param bleeding
     * @param _class
     * @param source
     * @param simcVersion
     * @param food
     * @param bloodlust
     */
    public SSimResponse(Long jobId, String simId, String simcVersion, String title, String type, String source, String origin, String player, String faction, String _class, String race, String spec, String role, String iterations, Long totalIterations, Boolean smartHighPrecision, String fightStyle, Long fightLength, String potion, String food, String flask, String augmentation, Boolean optimalRaid, Boolean bloodlust, Boolean arcaneIntellect, Boolean fortitude, Boolean battleShout, Boolean mysticTouch, Boolean chaosBrand, Long reoriginationArray, Boolean bleeding, Boolean reportDetails, Long enemyCount, String enemyType, String created, String frontendVersion, Boolean skipEnabled) {
        super();
        this.jobId = jobId;
        this.simId = simId;
        this.simcVersion = simcVersion;
        this.title = title;
        this.type = type;
        this.source = source;
        this.origin = origin;
        this.player = player;
        this.faction = faction;
        this._class = _class;
        this.race = race;
        this.spec = spec;
        this.role = role;
        this.iterations = iterations;
        this.totalIterations = totalIterations;
        this.smartHighPrecision = smartHighPrecision;
        this.fightStyle = fightStyle;
        this.fightLength = fightLength;
        this.potion = potion;
        this.food = food;
        this.flask = flask;
        this.augmentation = augmentation;
        this.optimalRaid = optimalRaid;
        this.bloodlust = bloodlust;
        this.arcaneIntellect = arcaneIntellect;
        this.fortitude = fortitude;
        this.battleShout = battleShout;
        this.mysticTouch = mysticTouch;
        this.chaosBrand = chaosBrand;
        this.reoriginationArray = reoriginationArray;
        this.bleeding = bleeding;
        this.reportDetails = reportDetails;
        this.enemyCount = enemyCount;
        this.enemyType = enemyType;
        this.created = created;
        this.frontendVersion = frontendVersion;
        this.skipEnabled = skipEnabled;
    }

    @JsonProperty("jobId")
    public Long getJobId() {
        return jobId;
    }

    @JsonProperty("jobId")
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    @JsonProperty("simId")
    public String getSimId() {
        return simId;
    }

    @JsonProperty("simId")
    public void setSimId(String simId) {
        this.simId = simId;
    }

    @JsonProperty("simcVersion")
    public String getSimcVersion() {
        return simcVersion;
    }

    @JsonProperty("simcVersion")
    public void setSimcVersion(String simcVersion) {
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

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("origin")
    public String getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @JsonProperty("player")
    public String getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(String player) {
        this.player = player;
    }

    @JsonProperty("faction")
    public String getFaction() {
        return faction;
    }

    @JsonProperty("faction")
    public void setFaction(String faction) {
        this.faction = faction;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("race")
    public String getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(String race) {
        this.race = race;
    }

    @JsonProperty("spec")
    public String getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(String spec) {
        this.spec = spec;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("iterations")
    public String getIterations() {
        return iterations;
    }

    @JsonProperty("iterations")
    public void setIterations(String iterations) {
        this.iterations = iterations;
    }

    @JsonProperty("totalIterations")
    public Long getTotalIterations() {
        return totalIterations;
    }

    @JsonProperty("totalIterations")
    public void setTotalIterations(Long totalIterations) {
        this.totalIterations = totalIterations;
    }

    @JsonProperty("smartHighPrecision")
    public Boolean getSmartHighPrecision() {
        return smartHighPrecision;
    }

    @JsonProperty("smartHighPrecision")
    public void setSmartHighPrecision(Boolean smartHighPrecision) {
        this.smartHighPrecision = smartHighPrecision;
    }

    @JsonProperty("fightStyle")
    public String getFightStyle() {
        return fightStyle;
    }

    @JsonProperty("fightStyle")
    public void setFightStyle(String fightStyle) {
        this.fightStyle = fightStyle;
    }

    @JsonProperty("fightLength")
    public Long getFightLength() {
        return fightLength;
    }

    @JsonProperty("fightLength")
    public void setFightLength(Long fightLength) {
        this.fightLength = fightLength;
    }

    @JsonProperty("potion")
    public String getPotion() {
        return potion;
    }

    @JsonProperty("potion")
    public void setPotion(String potion) {
        this.potion = potion;
    }

    @JsonProperty("food")
    public String getFood() {
        return food;
    }

    @JsonProperty("food")
    public void setFood(String food) {
        this.food = food;
    }

    @JsonProperty("flask")
    public String getFlask() {
        return flask;
    }

    @JsonProperty("flask")
    public void setFlask(String flask) {
        this.flask = flask;
    }

    @JsonProperty("augmentation")
    public String getAugmentation() {
        return augmentation;
    }

    @JsonProperty("augmentation")
    public void setAugmentation(String augmentation) {
        this.augmentation = augmentation;
    }

    @JsonProperty("optimalRaid")
    public Boolean getOptimalRaid() {
        return optimalRaid;
    }

    @JsonProperty("optimalRaid")
    public void setOptimalRaid(Boolean optimalRaid) {
        this.optimalRaid = optimalRaid;
    }

    @JsonProperty("bloodlust")
    public Boolean getBloodlust() {
        return bloodlust;
    }

    @JsonProperty("bloodlust")
    public void setBloodlust(Boolean bloodlust) {
        this.bloodlust = bloodlust;
    }

    @JsonProperty("arcaneIntellect")
    public Boolean getArcaneIntellect() {
        return arcaneIntellect;
    }

    @JsonProperty("arcaneIntellect")
    public void setArcaneIntellect(Boolean arcaneIntellect) {
        this.arcaneIntellect = arcaneIntellect;
    }

    @JsonProperty("fortitude")
    public Boolean getFortitude() {
        return fortitude;
    }

    @JsonProperty("fortitude")
    public void setFortitude(Boolean fortitude) {
        this.fortitude = fortitude;
    }

    @JsonProperty("battleShout")
    public Boolean getBattleShout() {
        return battleShout;
    }

    @JsonProperty("battleShout")
    public void setBattleShout(Boolean battleShout) {
        this.battleShout = battleShout;
    }

    @JsonProperty("mysticTouch")
    public Boolean getMysticTouch() {
        return mysticTouch;
    }

    @JsonProperty("mysticTouch")
    public void setMysticTouch(Boolean mysticTouch) {
        this.mysticTouch = mysticTouch;
    }

    @JsonProperty("chaosBrand")
    public Boolean getChaosBrand() {
        return chaosBrand;
    }

    @JsonProperty("chaosBrand")
    public void setChaosBrand(Boolean chaosBrand) {
        this.chaosBrand = chaosBrand;
    }

    @JsonProperty("reoriginationArray")
    public Long getReoriginationArray() {
        return reoriginationArray;
    }

    @JsonProperty("reoriginationArray")
    public void setReoriginationArray(Long reoriginationArray) {
        this.reoriginationArray = reoriginationArray;
    }

    @JsonProperty("bleeding")
    public Boolean getBleeding() {
        return bleeding;
    }

    @JsonProperty("bleeding")
    public void setBleeding(Boolean bleeding) {
        this.bleeding = bleeding;
    }

    @JsonProperty("reportDetails")
    public Boolean getReportDetails() {
        return reportDetails;
    }

    @JsonProperty("reportDetails")
    public void setReportDetails(Boolean reportDetails) {
        this.reportDetails = reportDetails;
    }

    @JsonProperty("enemyCount")
    public Long getEnemyCount() {
        return enemyCount;
    }

    @JsonProperty("enemyCount")
    public void setEnemyCount(Long enemyCount) {
        this.enemyCount = enemyCount;
    }

    @JsonProperty("enemyType")
    public String getEnemyType() {
        return enemyType;
    }

    @JsonProperty("enemyType")
    public void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("frontendVersion")
    public String getFrontendVersion() {
        return frontendVersion;
    }

    @JsonProperty("frontendVersion")
    public void setFrontendVersion(String frontendVersion) {
        this.frontendVersion = frontendVersion;
    }

    @JsonProperty("skipEnabled")
    public Boolean getSkipEnabled() {
        return skipEnabled;
    }

    @JsonProperty("skipEnabled")
    public void setSkipEnabled(Boolean skipEnabled) {
        this.skipEnabled = skipEnabled;
    }

}
