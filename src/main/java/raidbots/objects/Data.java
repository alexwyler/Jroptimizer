
package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "stage",
    "numStages",
    "stageTarget",
    "simId",
    "simcVersion",
    "meta"
})
public class Data {

    @JsonProperty("stage")
    private Long stage;
    @JsonProperty("numStages")
    private Long numStages;
    @JsonProperty("stageTarget")
    private Double stageTarget;
    @JsonProperty("simId")
    private String simId;
    @JsonProperty("simcVersion")
    private String simcVersion;
    @JsonProperty("meta")
    private Meta meta;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param stageTarget
     * @param numStages
     * @param simcVersion
     * @param simId
     * @param stage
     * @param meta
     */
    public Data(Long stage, Long numStages, Double stageTarget, String simId, String simcVersion, Meta meta) {
        super();
        this.stage = stage;
        this.numStages = numStages;
        this.stageTarget = stageTarget;
        this.simId = simId;
        this.simcVersion = simcVersion;
        this.meta = meta;
    }

    @JsonProperty("stage")
    public Long getStage() {
        return stage;
    }

    @JsonProperty("stage")
    public void setStage(Long stage) {
        this.stage = stage;
    }

    @JsonProperty("numStages")
    public Long getNumStages() {
        return numStages;
    }

    @JsonProperty("numStages")
    public void setNumStages(Long numStages) {
        this.numStages = numStages;
    }

    @JsonProperty("stageTarget")
    public Double getStageTarget() {
        return stageTarget;
    }

    @JsonProperty("stageTarget")
    public void setStageTarget(Double stageTarget) {
        this.stageTarget = stageTarget;
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

    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
