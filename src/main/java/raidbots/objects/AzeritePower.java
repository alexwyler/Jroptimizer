package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "tier",
        "spellId",
        "bonusListId"
})
public class AzeritePower {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("tier")
    private Long tier;
    @JsonProperty("spellId")
    private Long spellId;
    @JsonProperty("bonusListId")
    private Long bonusListId;
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

    @JsonProperty("tier")
    public Long getTier() {
        return tier;
    }

    @JsonProperty("tier")
    public void setTier(Long tier) {
        this.tier = tier;
    }

    @JsonProperty("spellId")
    public Long getSpellId() {
        return spellId;
    }

    @JsonProperty("spellId")
    public void setSpellId(Long spellId) {
        this.spellId = spellId;
    }

    @JsonProperty("bonusListId")
    public Long getBonusListId() {
        return bonusListId;
    }

    @JsonProperty("bonusListId")
    public void setBonusListId(Long bonusListId) {
        this.bonusListId = bonusListId;
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
