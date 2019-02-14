
package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "total",
    "position",
    "avgWaitPublic",
    "avgWaitPatron",
    "avgWaitPublicNice",
    "avgWaitPatronNice"
})
public class Queue {

    @JsonProperty("total")
    private Long total;
    @JsonProperty("position")
    private Long position;
    @JsonProperty("avgWaitPublic")
    private Long avgWaitPublic;
    @JsonProperty("avgWaitPatron")
    private Long avgWaitPatron;
    @JsonProperty("avgWaitPublicNice")
    private String avgWaitPublicNice;
    @JsonProperty("avgWaitPatronNice")
    private String avgWaitPatronNice;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Queue() {
    }

    /**
     * 
     * @param position
     * @param total
     * @param avgWaitPublicNice
     * @param avgWaitPatron
     * @param avgWaitPatronNice
     * @param avgWaitPublic
     */
    public Queue(Long total, Long position, Long avgWaitPublic, Long avgWaitPatron, String avgWaitPublicNice, String avgWaitPatronNice) {
        super();
        this.total = total;
        this.position = position;
        this.avgWaitPublic = avgWaitPublic;
        this.avgWaitPatron = avgWaitPatron;
        this.avgWaitPublicNice = avgWaitPublicNice;
        this.avgWaitPatronNice = avgWaitPatronNice;
    }

    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Long total) {
        this.total = total;
    }

    @JsonProperty("position")
    public Long getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Long position) {
        this.position = position;
    }

    @JsonProperty("avgWaitPublic")
    public Long getAvgWaitPublic() {
        return avgWaitPublic;
    }

    @JsonProperty("avgWaitPublic")
    public void setAvgWaitPublic(Long avgWaitPublic) {
        this.avgWaitPublic = avgWaitPublic;
    }

    @JsonProperty("avgWaitPatron")
    public Long getAvgWaitPatron() {
        return avgWaitPatron;
    }

    @JsonProperty("avgWaitPatron")
    public void setAvgWaitPatron(Long avgWaitPatron) {
        this.avgWaitPatron = avgWaitPatron;
    }

    @JsonProperty("avgWaitPublicNice")
    public String getAvgWaitPublicNice() {
        return avgWaitPublicNice;
    }

    @JsonProperty("avgWaitPublicNice")
    public void setAvgWaitPublicNice(String avgWaitPublicNice) {
        this.avgWaitPublicNice = avgWaitPublicNice;
    }

    @JsonProperty("avgWaitPatronNice")
    public String getAvgWaitPatronNice() {
        return avgWaitPatronNice;
    }

    @JsonProperty("avgWaitPatronNice")
    public void setAvgWaitPatronNice(String avgWaitPatronNice) {
        this.avgWaitPatronNice = avgWaitPatronNice;
    }

}
