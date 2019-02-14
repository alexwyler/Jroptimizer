package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "itemId",
        "itemAppearanceModId",
        "transmogItemAppearanceModId"
})
public class Appearance {

    @JsonProperty("itemId")
    private Long itemId;
    @JsonProperty("itemAppearanceModId")
    private Long itemAppearanceModId;
    @JsonProperty("transmogItemAppearanceModId")
    private Long transmogItemAppearanceModId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("itemId")
    public Long getItemId() {
        return itemId;
    }

    @JsonProperty("itemId")
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @JsonProperty("itemAppearanceModId")
    public Long getItemAppearanceModId() {
        return itemAppearanceModId;
    }

    @JsonProperty("itemAppearanceModId")
    public void setItemAppearanceModId(Long itemAppearanceModId) {
        this.itemAppearanceModId = itemAppearanceModId;
    }

    @JsonProperty("transmogItemAppearanceModId")
    public Long getTransmogItemAppearanceModId() {
        return transmogItemAppearanceModId;
    }

    @JsonProperty("transmogItemAppearanceModId")
    public void setTransmogItemAppearanceModId(Long transmogItemAppearanceModId) {
        this.transmogItemAppearanceModId = transmogItemAppearanceModId;
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
