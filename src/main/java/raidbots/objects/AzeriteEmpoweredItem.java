package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "azeritePowers"
})
public class AzeriteEmpoweredItem {

    @JsonProperty("azeritePowers")
    private List<AzeritePower>  azeritePowers        = new ArrayList<AzeritePower>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("azeritePowers")
    public List<AzeritePower> getAzeritePowers() {
        return azeritePowers;
    }

    @JsonProperty("azeritePowers")
    public void setAzeritePowers(List<AzeritePower> azeritePowers) {
        this.azeritePowers = azeritePowers;
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
