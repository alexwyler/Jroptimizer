package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "icon",
        "description",
        "castTime",
        "subtext",
        "cooldown",
        "range",
        "powerCost"
})
public class Spell {

    @JsonProperty("id")
    private Long   id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("description")
    private String description;
    @JsonProperty("castTime")
    private String castTime;
    @JsonProperty("subtext")
    private String subtext;
    @JsonProperty("cooldown")
    private String cooldown;
    @JsonProperty("range")
    private String range;
    @JsonProperty("powerCost")
    private String powerCost;
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

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("castTime")
    public String getCastTime() {
        return castTime;
    }

    @JsonProperty("castTime")
    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    @JsonProperty("subtext")
    public String getSubtext() {
        return subtext;
    }

    @JsonProperty("subtext")
    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    @JsonProperty("cooldown")
    public String getCooldown() {
        return cooldown;
    }

    @JsonProperty("cooldown")
    public void setCooldown(String cooldown) {
        this.cooldown = cooldown;
    }

    @JsonProperty("range")
    public String getRange() {
        return range;
    }

    @JsonProperty("range")
    public void setRange(String range) {
        this.range = range;
    }

    @JsonProperty("powerCost")
    public String getPowerCost() {
        return powerCost;
    }

    @JsonProperty("powerCost")
    public void setPowerCost(String powerCost) {
        this.powerCost = powerCost;
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
