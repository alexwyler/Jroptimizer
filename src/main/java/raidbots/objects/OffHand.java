package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "icon",
        "quality",
        "itemLevel",
        "tooltipParams",
        "stats",
        "armor",
        "context",
        "bonusLists",
        "artifactId",
        "displayInfoId",
        "artifactAppearanceId",
        "artifactTraits",
        "relics",
        "appearance",
        "azeriteItem",
        "azeriteEmpoweredItem",
        "inventoryType",
        "itemClass",
        "itemSubClass"
})
public class OffHand {

    @JsonProperty("id")
    private Long          id;
    @JsonProperty("name")
    private String        name;
    @JsonProperty("icon")
    private String        icon;
    @JsonProperty("quality")
    private Long          quality;
    @JsonProperty("itemLevel")
    private Long          itemLevel;
    @JsonProperty("tooltipParams")
    private TooltipParams tooltipParams;
    @JsonProperty("stats")
    private List<Stat> stats = new ArrayList<Stat>();
    @JsonProperty("armor")
    private Long   armor;
    @JsonProperty("context")
    private String context;
    @JsonProperty("bonusLists")
    private List<Long> bonusLists = new ArrayList<Long>();
    @JsonProperty("artifactId")
    private Long artifactId;
    @JsonProperty("displayInfoId")
    private Long displayInfoId;
    @JsonProperty("artifactAppearanceId")
    private Long artifactAppearanceId;
    @JsonProperty("artifactTraits")
    private List<Object> artifactTraits = new ArrayList<Object>();
    @JsonProperty("relics")
    private List<Object> relics         = new ArrayList<Object>();
    @JsonProperty("appearance")
    private Appearance           appearance;
    @JsonProperty("azeriteItem")
    private AzeriteItem          azeriteItem;
    @JsonProperty("azeriteEmpoweredItem")
    private AzeriteEmpoweredItem azeriteEmpoweredItem;
    @JsonProperty("inventoryType")
    private Long                 inventoryType;
    @JsonProperty("itemClass")
    private Long                 itemClass;
    @JsonProperty("itemSubClass")
    private Long                 itemSubClass;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("quality")
    public Long getQuality() {
        return quality;
    }

    @JsonProperty("quality")
    public void setQuality(Long quality) {
        this.quality = quality;
    }

    @JsonProperty("itemLevel")
    public Long getItemLevel() {
        return itemLevel;
    }

    @JsonProperty("itemLevel")
    public void setItemLevel(Long itemLevel) {
        this.itemLevel = itemLevel;
    }

    @JsonProperty("tooltipParams")
    public TooltipParams getTooltipParams() {
        return tooltipParams;
    }

    @JsonProperty("tooltipParams")
    public void setTooltipParams(TooltipParams tooltipParams) {
        this.tooltipParams = tooltipParams;
    }

    @JsonProperty("stats")
    public List<Stat> getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    @JsonProperty("armor")
    public Long getArmor() {
        return armor;
    }

    @JsonProperty("armor")
    public void setArmor(Long armor) {
        this.armor = armor;
    }

    @JsonProperty("context")
    public String getContext() {
        return context;
    }

    @JsonProperty("context")
    public void setContext(String context) {
        this.context = context;
    }

    @JsonProperty("bonusLists")
    public List<Long> getBonusLists() {
        return bonusLists;
    }

    @JsonProperty("bonusLists")
    public void setBonusLists(List<Long> bonusLists) {
        this.bonusLists = bonusLists;
    }

    @JsonProperty("artifactId")
    public Long getArtifactId() {
        return artifactId;
    }

    @JsonProperty("artifactId")
    public void setArtifactId(Long artifactId) {
        this.artifactId = artifactId;
    }

    @JsonProperty("displayInfoId")
    public Long getDisplayInfoId() {
        return displayInfoId;
    }

    @JsonProperty("displayInfoId")
    public void setDisplayInfoId(Long displayInfoId) {
        this.displayInfoId = displayInfoId;
    }

    @JsonProperty("artifactAppearanceId")
    public Long getArtifactAppearanceId() {
        return artifactAppearanceId;
    }

    @JsonProperty("artifactAppearanceId")
    public void setArtifactAppearanceId(Long artifactAppearanceId) {
        this.artifactAppearanceId = artifactAppearanceId;
    }

    @JsonProperty("artifactTraits")
    public List<Object> getArtifactTraits() {
        return artifactTraits;
    }

    @JsonProperty("artifactTraits")
    public void setArtifactTraits(List<Object> artifactTraits) {
        this.artifactTraits = artifactTraits;
    }

    @JsonProperty("relics")
    public List<Object> getRelics() {
        return relics;
    }

    @JsonProperty("relics")
    public void setRelics(List<Object> relics) {
        this.relics = relics;
    }

    @JsonProperty("appearance")
    public Appearance getAppearance() {
        return appearance;
    }

    @JsonProperty("appearance")
    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    @JsonProperty("azeriteItem")
    public AzeriteItem getAzeriteItem() {
        return azeriteItem;
    }

    @JsonProperty("azeriteItem")
    public void setAzeriteItem(AzeriteItem azeriteItem) {
        this.azeriteItem = azeriteItem;
    }

    @JsonProperty("azeriteEmpoweredItem")
    public AzeriteEmpoweredItem getAzeriteEmpoweredItem() {
        return azeriteEmpoweredItem;
    }

    @JsonProperty("azeriteEmpoweredItem")
    public void setAzeriteEmpoweredItem(AzeriteEmpoweredItem azeriteEmpoweredItem) {
        this.azeriteEmpoweredItem = azeriteEmpoweredItem;
    }

    @JsonProperty("inventoryType")
    public Long getInventoryType() {
        return inventoryType;
    }

    @JsonProperty("inventoryType")
    public void setInventoryType(Long inventoryType) {
        this.inventoryType = inventoryType;
    }

    @JsonProperty("itemClass")
    public Long getItemClass() {
        return itemClass;
    }

    @JsonProperty("itemClass")
    public void setItemClass(Long itemClass) {
        this.itemClass = itemClass;
    }

    @JsonProperty("itemSubClass")
    public Long getItemSubClass() {
        return itemSubClass;
    }

    @JsonProperty("itemSubClass")
    public void setItemSubClass(Long itemSubClass) {
        this.itemSubClass = itemSubClass;
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
