package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "equipped",
        "instances",
        "difficulty",
        "classId",
        "specId",
        "faction"
})
public class Droptimizer {

    @JsonProperty("equipped")
    private Items equipped;
    @JsonProperty("instances")
    private List<Long> instances = new ArrayList<Long>();
    @JsonProperty("difficulty")
    private String difficulty;
    @JsonProperty("classId")
    private Long   classId;
    @JsonProperty("specId")
    private Long   specId;
    @JsonProperty("faction")
    private String faction;

    /**
     * No args constructor for use in serialization
     */
    public Droptimizer() {
    }

    /**
     * @param classId
     * @param specId
     * @param faction
     * @param equipped
     * @param difficulty
     * @param instances
     */
    public Droptimizer(Items equipped, List<Long> instances, String difficulty, Long classId, Long specId, String faction) {
        super();
        this.equipped = equipped;
        this.instances = instances;
        this.difficulty = difficulty;
        this.classId = classId;
        this.specId = specId;
        this.faction = faction;
    }

    @JsonProperty("equipped")
    public Items getEquipped() {
        return equipped;
    }

    @JsonProperty("equipped")
    public void setEquipped(Items equipped) {
        this.equipped = equipped;
    }

    @JsonProperty("instances")
    public List<Long> getInstances() {
        return instances;
    }

    @JsonProperty("instances")
    public void setInstances(List<Long> instances) {
        this.instances = instances;
    }

    @JsonProperty("difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    @JsonProperty("difficulty")
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @JsonProperty("classId")
    public Long getClassId() {
        return classId;
    }

    @JsonProperty("classId")
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @JsonProperty("specId")
    public Long getSpecId() {
        return specId;
    }

    @JsonProperty("specId")
    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    @JsonProperty("faction")
    public String getFaction() {
        return faction;
    }

    @JsonProperty("faction")
    public void setFaction(String faction) {
        this.faction = faction;
    }

}
