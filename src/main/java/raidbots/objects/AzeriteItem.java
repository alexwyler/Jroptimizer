package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "azeriteLevel",
        "azeriteExperience",
        "azeriteExperienceRemaining"
})
public class AzeriteItem {

    @JsonProperty("azeriteLevel")
    private Long azeriteLevel;
    @JsonProperty("azeriteExperience")
    private Long azeriteExperience;
    @JsonProperty("azeriteExperienceRemaining")
    private Long azeriteExperienceRemaining;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("azeriteLevel")
    public Long getAzeriteLevel() {
        return azeriteLevel;
    }

    @JsonProperty("azeriteLevel")
    public void setAzeriteLevel(Long azeriteLevel) {
        this.azeriteLevel = azeriteLevel;
    }

    @JsonProperty("azeriteExperience")
    public Long getAzeriteExperience() {
        return azeriteExperience;
    }

    @JsonProperty("azeriteExperience")
    public void setAzeriteExperience(Long azeriteExperience) {
        this.azeriteExperience = azeriteExperience;
    }

    @JsonProperty("azeriteExperienceRemaining")
    public Long getAzeriteExperienceRemaining() {
        return azeriteExperienceRemaining;
    }

    @JsonProperty("azeriteExperienceRemaining")
    public void setAzeriteExperienceRemaining(Long azeriteExperienceRemaining) {
        this.azeriteExperienceRemaining = azeriteExperienceRemaining;
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
