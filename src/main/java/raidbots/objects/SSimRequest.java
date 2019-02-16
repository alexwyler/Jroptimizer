package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "type",
        "text",
        "baseActorName",
        "reportName",
        "armory",
        "email",
        "sendEmail",
        "character",
        "spec",
        "simcItems",
        "gearsets",
        "talents",
        "talentSets",
        "droptimizer",
        "simcVersion",
        "iterations",
        "smartHighPrecision",
        "fightStyle",
        "fightLength",
        "enemyCount",
        "enemyType",
        "potion",
        "food",
        "flask",
        "augmentation",
        "bloodlust",
        "arcaneIntellect",
        "fortitude",
        "battleShout",
        "mysticTouch",
        "chaosBrand",
        "bleeding",
        "reoriginationArray",
        "reportDetails",
        "pantheonTrinkets",
        "zuldazar",
        "covenantChance",
        "apl",
        "ptr",
        "frontendHost",
        "frontendVersion"
})
public class SSimRequest {

    @JsonProperty("type")
    private String    type;
    @JsonProperty("text")
    private String    text;
    @JsonProperty("baseActorName")
    private String    baseActorName;
    @JsonProperty("reportName")
    private String    reportName;
    @JsonProperty("armory")
    private Armory    armory;
    @JsonProperty("email")
    private String    email;
    @JsonProperty("sendEmail")
    private Boolean   sendEmail;
    @JsonProperty("character")
    private Character character;
    @JsonProperty("spec")
    private String    spec;
    @JsonProperty("simcItems")
    private SimcItems simcItems;
    @JsonProperty("gearsets")
    private List<Object> gearsets = new ArrayList<Object>();
    @JsonInclude(JsonInclude.Include.ALWAYS)
    @JsonProperty("talents")
    private Object talents;
    @JsonProperty("talentSets")
    private List<Object> talentSets = new ArrayList<Object>();
    @JsonProperty("droptimizer")
    private Droptimizer droptimizer;
    @JsonProperty("simcVersion")
    private String      simcVersion;
    @JsonProperty("iterations")
    private String      iterations;
    @JsonProperty("smartHighPrecision")
    private Boolean     smartHighPrecision;
    @JsonProperty("fightStyle")
    private String      fightStyle;
    @JsonProperty("fightLength")
    private Long        fightLength;
    @JsonProperty("enemyCount")
    private Long        enemyCount;
    @JsonProperty("enemyType")
    private String      enemyType;
    @JsonProperty("potion")
    private String      potion;
    @JsonProperty("food")
    private String      food;
    @JsonProperty("flask")
    private String      flask;
    @JsonProperty("augmentation")
    private String      augmentation;
    @JsonProperty("bloodlust")
    private Boolean     bloodlust;
    @JsonProperty("arcaneIntellect")
    private Boolean     arcaneIntellect;
    @JsonProperty("fortitude")
    private Boolean     fortitude;
    @JsonProperty("battleShout")
    private Boolean     battleShout;
    @JsonProperty("mysticTouch")
    private Boolean     mysticTouch;
    @JsonProperty("chaosBrand")
    private Boolean     chaosBrand;
    @JsonProperty("bleeding")
    private Boolean     bleeding;
    @JsonProperty("reoriginationArray")
    private Long        reoriginationArray;
    @JsonProperty("reportDetails")
    private Boolean     reportDetails;
    @JsonProperty("pantheonTrinkets")
    private Long        pantheonTrinkets;
    @JsonProperty("zuldazar")
    private Boolean     zuldazar;
    @JsonProperty("covenantChance")
    private Long        covenantChance;
    @JsonProperty("apl")
    private String      apl;
    @JsonProperty("ptr")
    private Boolean     ptr;
    @JsonProperty("frontendHost")
    private String      frontendHost;
    @JsonProperty("frontendVersion")
    private String      frontendVersion;

    /**
     * No args constructor for use in serialization
     */
    public SSimRequest() {
    }

    public SSimRequest(Droptimizer droptimizer) {
        super();
        this.droptimizer = droptimizer;
    }

    /**
     * @param spec
     * @param frontendHost
     * @param flask
     * @param fortitude
     * @param type
     * @param zuldazar
     * @param character
     * @param augmentation
     * @param talentSets
     * @param frontendVersion
     * @param droptimizer
     * @param armory
     * @param potion
     * @param gearsets
     * @param reportName
     * @param fightStyle
     * @param apl
     * @param arcaneIntellect
     * @param text
     * @param fightLength
     * @param covenantChance
     * @param smartHighPrecision
     * @param reoriginationArray
     * @param talents
     * @param iterations
     * @param mysticTouch
     * @param simcItems
     * @param chaosBrand
     * @param enemyType
     * @param enemyCount
     * @param reportDetails
     * @param battleShout
     * @param bleeding
     * @param baseActorName
     * @param email
     * @param simcVersion
     * @param bloodlust
     * @param food
     * @param pantheonTrinkets
     * @param sendEmail
     * @param ptr
     */
    public SSimRequest(String type, String text, String baseActorName, String reportName, Armory armory, String email, Boolean sendEmail, Character character, String spec, SimcItems simcItems, List<Object> gearsets, Object talents, List<Object> talentSets, Droptimizer droptimizer, String simcVersion, String iterations, Boolean smartHighPrecision, String fightStyle, Long fightLength, Long enemyCount, String enemyType, String potion, String food, String flask, String augmentation, Boolean bloodlust, Boolean arcaneIntellect, Boolean fortitude, Boolean battleShout, Boolean mysticTouch, Boolean chaosBrand, Boolean bleeding, Long reoriginationArray, Boolean reportDetails, Long pantheonTrinkets, Boolean zuldazar, Long covenantChance, String apl, Boolean ptr, String frontendHost, String frontendVersion) {
        super();
        this.type = type;
        this.text = text;
        this.baseActorName = baseActorName;
        this.reportName = reportName;
        this.armory = armory;
        this.email = email;
        this.sendEmail = sendEmail;
        this.character = character;
        this.spec = spec;
        this.simcItems = simcItems;
        this.gearsets = gearsets;
        this.talents = talents;
        this.talentSets = talentSets;
        this.droptimizer = droptimizer;
        this.simcVersion = simcVersion;
        this.iterations = iterations;
        this.smartHighPrecision = smartHighPrecision;
        this.fightStyle = fightStyle;
        this.fightLength = fightLength;
        this.enemyCount = enemyCount;
        this.enemyType = enemyType;
        this.potion = potion;
        this.food = food;
        this.flask = flask;
        this.augmentation = augmentation;
        this.bloodlust = bloodlust;
        this.arcaneIntellect = arcaneIntellect;
        this.fortitude = fortitude;
        this.battleShout = battleShout;
        this.mysticTouch = mysticTouch;
        this.chaosBrand = chaosBrand;
        this.bleeding = bleeding;
        this.reoriginationArray = reoriginationArray;
        this.reportDetails = reportDetails;
        this.pantheonTrinkets = pantheonTrinkets;
        this.zuldazar = zuldazar;
        this.covenantChance = covenantChance;
        this.apl = apl;
        this.ptr = ptr;
        this.frontendHost = frontendHost;
        this.frontendVersion = frontendVersion;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("baseActorName")
    public String getBaseActorName() {
        return baseActorName;
    }

    @JsonProperty("baseActorName")
    public void setBaseActorName(String baseActorName) {
        this.baseActorName = baseActorName;
    }

    @JsonProperty("reportName")
    public String getReportName() {
        return reportName;
    }

    @JsonProperty("reportName")
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    @JsonProperty("armory")
    public Armory getArmory() {
        return armory;
    }

    @JsonProperty("armory")
    public void setArmory(Armory armory) {
        this.armory = armory;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("sendEmail")
    public Boolean getSendEmail() {
        return sendEmail;
    }

    @JsonProperty("sendEmail")
    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    @JsonProperty("character")
    public Character getCharacter() {
        return character;
    }

    @JsonProperty("character")
    public void setCharacter(Character character) {
        this.character = character;
    }

    @JsonProperty("spec")
    public String getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(String spec) {
        this.spec = spec;
    }

    @JsonProperty("simcItems")
    public SimcItems getSimcItems() {
        return simcItems;
    }

    @JsonProperty("simcItems")
    public void setSimcItems(SimcItems simcItems) {
        this.simcItems = simcItems;
    }

    @JsonProperty("gearsets")
    public List<Object> getGearsets() {
        return gearsets;
    }

    @JsonProperty("gearsets")
    public void setGearsets(List<Object> gearsets) {
        this.gearsets = gearsets;
    }

    @JsonProperty("talents")
    public Object getTalents() {
        return talents;
    }

    @JsonProperty("talents")
    public void setTalents(Object talents) {
        this.talents = talents;
    }

    @JsonProperty("talentSets")
    public List<Object> getTalentSets() {
        return talentSets;
    }

    @JsonProperty("talentSets")
    public void setTalentSets(List<Object> talentSets) {
        this.talentSets = talentSets;
    }

    @JsonProperty("droptimizer")
    public Droptimizer getDroptimizer() {
        return droptimizer;
    }

    @JsonProperty("droptimizer")
    public void setDroptimizer(Droptimizer droptimizer) {
        this.droptimizer = droptimizer;
    }

    @JsonProperty("simcVersion")
    public String getSimcVersion() {
        return simcVersion;
    }

    @JsonProperty("simcVersion")
    public void setSimcVersion(String simcVersion) {
        this.simcVersion = simcVersion;
    }

    @JsonProperty("iterations")
    public String getIterations() {
        return iterations;
    }

    @JsonProperty("iterations")
    public void setIterations(String iterations) {
        this.iterations = iterations;
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

    @JsonProperty("bleeding")
    public Boolean getBleeding() {
        return bleeding;
    }

    @JsonProperty("bleeding")
    public void setBleeding(Boolean bleeding) {
        this.bleeding = bleeding;
    }

    @JsonProperty("reoriginationArray")
    public Long getReoriginationArray() {
        return reoriginationArray;
    }

    @JsonProperty("reoriginationArray")
    public void setReoriginationArray(Long reoriginationArray) {
        this.reoriginationArray = reoriginationArray;
    }

    @JsonProperty("reportDetails")
    public Boolean getReportDetails() {
        return reportDetails;
    }

    @JsonProperty("reportDetails")
    public void setReportDetails(Boolean reportDetails) {
        this.reportDetails = reportDetails;
    }

    @JsonProperty("pantheonTrinkets")
    public Long getPantheonTrinkets() {
        return pantheonTrinkets;
    }

    @JsonProperty("pantheonTrinkets")
    public void setPantheonTrinkets(Long pantheonTrinkets) {
        this.pantheonTrinkets = pantheonTrinkets;
    }

    @JsonProperty("zuldazar")
    public Boolean getZuldazar() {
        return zuldazar;
    }

    @JsonProperty("zuldazar")
    public void setZuldazar(Boolean zuldazar) {
        this.zuldazar = zuldazar;
    }

    @JsonProperty("covenantChance")
    public Long getCovenantChance() {
        return covenantChance;
    }

    @JsonProperty("covenantChance")
    public void setCovenantChance(Long covenantChance) {
        this.covenantChance = covenantChance;
    }

    @JsonProperty("apl")
    public String getApl() {
        return apl;
    }

    @JsonProperty("apl")
    public void setApl(String apl) {
        this.apl = apl;
    }

    @JsonProperty("ptr")
    public Boolean getPtr() {
        return ptr;
    }

    @JsonProperty("ptr")
    public void setPtr(Boolean ptr) {
        this.ptr = ptr;
    }

    @JsonProperty("frontendHost")
    public String getFrontendHost() {
        return frontendHost;
    }

    @JsonProperty("frontendHost")
    public void setFrontendHost(String frontendHost) {
        this.frontendHost = frontendHost;
    }

    @JsonProperty("frontendVersion")
    public String getFrontendVersion() {
        return frontendVersion;
    }

    @JsonProperty("frontendVersion")
    public void setFrontendVersion(String frontendVersion) {
        this.frontendVersion = frontendVersion;
    }

}
