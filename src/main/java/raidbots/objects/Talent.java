package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "selected",
        "talents",
        "spec",
        "calcTalent",
        "calcSpec"
})
public class Talent {

    @JsonProperty("selected")
    private Boolean selected;
    @JsonProperty("talents")
    private List<Talent> talents = new ArrayList<Talent>();
    @JsonProperty("spec")
    private Spec   spec;
    @JsonProperty("calcTalent")
    private String calcTalent;
    @JsonProperty("calcSpec")
    private String calcSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("selected")
    public Boolean getSelected() {
        return selected;
    }

    @JsonProperty("selected")
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @JsonProperty("talents")
    public List<Talent> getTalents() {
        return talents;
    }

    @JsonProperty("talents")
    public void setTalents(List<Talent> talents) {
        this.talents = talents;
    }

    @JsonProperty("spec")
    public Spec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    @JsonProperty("calcTalent")
    public String getCalcTalent() {
        return calcTalent;
    }

    @JsonProperty("calcTalent")
    public void setCalcTalent(String calcTalent) {
        this.calcTalent = calcTalent;
    }

    @JsonProperty("calcSpec")
    public String getCalcSpec() {
        return calcSpec;
    }

    @JsonProperty("calcSpec")
    public void setCalcSpec(String calcSpec) {
        this.calcSpec = calcSpec;
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
