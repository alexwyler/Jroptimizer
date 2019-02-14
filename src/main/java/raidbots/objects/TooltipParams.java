package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "transmogItem",
        "timewalkerLevel",
        "azeritePower0",
        "azeritePower1",
        "azeritePower2",
        "azeritePower3",
        "azeritePowerLevel",
        "azeritePower4"
})
public class TooltipParams {

    @JsonProperty("transmogItem")
    private Long transmogItem;
    @JsonProperty("timewalkerLevel")
    private Long timewalkerLevel;
    @JsonProperty("azeritePower0")
    private Long azeritePower0;
    @JsonProperty("azeritePower1")
    private Long azeritePower1;
    @JsonProperty("azeritePower2")
    private Long azeritePower2;
    @JsonProperty("azeritePower3")
    private Long azeritePower3;
    @JsonProperty("azeritePowerLevel")
    private Long azeritePowerLevel;
    @JsonProperty("azeritePower4")
    private Long azeritePower4;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("transmogItem")
    public Long getTransmogItem() {
        return transmogItem;
    }

    @JsonProperty("transmogItem")
    public void setTransmogItem(Long transmogItem) {
        this.transmogItem = transmogItem;
    }

    @JsonProperty("timewalkerLevel")
    public Long getTimewalkerLevel() {
        return timewalkerLevel;
    }

    @JsonProperty("timewalkerLevel")
    public void setTimewalkerLevel(Long timewalkerLevel) {
        this.timewalkerLevel = timewalkerLevel;
    }

    @JsonProperty("azeritePower0")
    public Long getAzeritePower0() {
        return azeritePower0;
    }

    @JsonProperty("azeritePower0")
    public void setAzeritePower0(Long azeritePower0) {
        this.azeritePower0 = azeritePower0;
    }

    @JsonProperty("azeritePower1")
    public Long getAzeritePower1() {
        return azeritePower1;
    }

    @JsonProperty("azeritePower1")
    public void setAzeritePower1(Long azeritePower1) {
        this.azeritePower1 = azeritePower1;
    }

    @JsonProperty("azeritePower2")
    public Long getAzeritePower2() {
        return azeritePower2;
    }

    @JsonProperty("azeritePower2")
    public void setAzeritePower2(Long azeritePower2) {
        this.azeritePower2 = azeritePower2;
    }

    @JsonProperty("azeritePower3")
    public Long getAzeritePower3() {
        return azeritePower3;
    }

    @JsonProperty("azeritePower3")
    public void setAzeritePower3(Long azeritePower3) {
        this.azeritePower3 = azeritePower3;
    }

    @JsonProperty("azeritePowerLevel")
    public Long getAzeritePowerLevel() {
        return azeritePowerLevel;
    }

    @JsonProperty("azeritePowerLevel")
    public void setAzeritePowerLevel(Long azeritePowerLevel) {
        this.azeritePowerLevel = azeritePowerLevel;
    }

    @JsonProperty("azeritePower4")
    public Long getAzeritePower4() {
        return azeritePower4;
    }

    @JsonProperty("azeritePower4")
    public void setAzeritePower4(Long azeritePower4) {
        this.azeritePower4 = azeritePower4;
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
