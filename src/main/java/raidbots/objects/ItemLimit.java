package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "category",
        "quantity"
})
public class ItemLimit {

    @JsonProperty("category")
    private Long category;
    @JsonProperty("quantity")
    private Long quantity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("category")
    public Long getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Long category) {
        this.category = category;
    }

    @JsonProperty("quantity")
    public Long getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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
