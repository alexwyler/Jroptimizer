
package raidbots.objects;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "state",
    "progress",
    "data"
})
public class Job {

    @JsonProperty("state")
    private String state;
    @JsonProperty("progress")
    private Long progress;
    @JsonProperty("data")
    private Data data;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Job() {
    }

    /**
     * 
     * @param progress
     * @param data
     * @param state
     */
    public Job(String state, Long progress, Data data) {
        super();
        this.state = state;
        this.progress = progress;
        this.data = data;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("progress")
    public Long getProgress() {
        return progress;
    }

    @JsonProperty("progress")
    public void setProgress(Long progress) {
        this.progress = progress;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

}
