
package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "job",
    "log",
    "retriesRemaining",
    "queue"
})
public class SSimStatus {

    @JsonProperty("job")
    private Job job;
    @JsonProperty("log")
    private List<String> log = new ArrayList<String>();
    @JsonProperty("retriesRemaining")
    private Long retriesRemaining;
    @JsonProperty("queue")
    private Queue queue;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SSimStatus() {
    }

    /**
     * 
     * @param queue
     * @param retriesRemaining
     * @param job
     * @param log
     */
    public SSimStatus(Job job, List<String> log, Long retriesRemaining, Queue queue) {
        super();
        this.job = job;
        this.log = log;
        this.retriesRemaining = retriesRemaining;
        this.queue = queue;
    }

    @JsonProperty("job")
    public Job getJob() {
        return job;
    }

    @JsonProperty("job")
    public void setJob(Job job) {
        this.job = job;
    }

    @JsonProperty("log")
    public List<String> getLog() {
        return log;
    }

    @JsonProperty("log")
    public void setLog(List<String> log) {
        this.log = log;
    }

    @JsonProperty("retriesRemaining")
    public Long getRetriesRemaining() {
        return retriesRemaining;
    }

    @JsonProperty("retriesRemaining")
    public void setRetriesRemaining(Long retriesRemaining) {
        this.retriesRemaining = retriesRemaining;
    }

    @JsonProperty("queue")
    public Queue getQueue() {
        return queue;
    }

    @JsonProperty("queue")
    public void setQueue(Queue queue) {
        this.queue = queue;
    }

}
