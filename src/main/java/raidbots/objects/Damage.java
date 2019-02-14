package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "min",
        "max",
        "exactMin",
        "exactMax"
})
public class Damage {

    @JsonProperty("min")
    private Long min;
    @JsonProperty("max")
    private Long max;
    @JsonProperty("exactMin")
    private Long exactMin;
    @JsonProperty("exactMax")
    private Long exactMax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("min")
    public Long getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Long min) {
        this.min = min;
    }

    @JsonProperty("max")
    public Long getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Long max) {
        this.max = max;
    }

    @JsonProperty("exactMin")
    public Long getExactMin() {
        return exactMin;
    }

    @JsonProperty("exactMin")
    public void setExactMin(Long exactMin) {
        this.exactMin = exactMin;
    }

    @JsonProperty("exactMax")
    public Long getExactMax() {
        return exactMax;
    }

    @JsonProperty("exactMax")
    public void setExactMax(Long exactMax) {
        this.exactMax = exactMax;
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
