package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "stat",
        "amount"
})
public class Stat {

    @JsonProperty("stat")
    private Long stat;
    @JsonProperty("amount")
    private Long amount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("stat")
    public Long getStat() {
        return stat;
    }

    @JsonProperty("stat")
    public void setStat(Long stat) {
        this.stat = stat;
    }

    @JsonProperty("amount")
    public Long getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Long amount) {
        this.amount = amount;
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
