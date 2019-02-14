package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "icon",
        "iconColor",
        "iconColorId",
        "border",
        "borderColor",
        "borderColorId",
        "backgroundColor",
        "backgroundColorId"
})
public class Emblem {

    @JsonProperty("icon")
    private Long   icon;
    @JsonProperty("iconColor")
    private String iconColor;
    @JsonProperty("iconColorId")
    private Long   iconColorId;
    @JsonProperty("border")
    private Long   border;
    @JsonProperty("borderColor")
    private String borderColor;
    @JsonProperty("borderColorId")
    private Long   borderColorId;
    @JsonProperty("backgroundColor")
    private String backgroundColor;
    @JsonProperty("backgroundColorId")
    private Long   backgroundColorId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("icon")
    public Long getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(Long icon) {
        this.icon = icon;
    }

    @JsonProperty("iconColor")
    public String getIconColor() {
        return iconColor;
    }

    @JsonProperty("iconColor")
    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }

    @JsonProperty("iconColorId")
    public Long getIconColorId() {
        return iconColorId;
    }

    @JsonProperty("iconColorId")
    public void setIconColorId(Long iconColorId) {
        this.iconColorId = iconColorId;
    }

    @JsonProperty("border")
    public Long getBorder() {
        return border;
    }

    @JsonProperty("border")
    public void setBorder(Long border) {
        this.border = border;
    }

    @JsonProperty("borderColor")
    public String getBorderColor() {
        return borderColor;
    }

    @JsonProperty("borderColor")
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @JsonProperty("borderColorId")
    public Long getBorderColorId() {
        return borderColorId;
    }

    @JsonProperty("borderColorId")
    public void setBorderColorId(Long borderColorId) {
        this.borderColorId = borderColorId;
    }

    @JsonProperty("backgroundColor")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @JsonProperty("backgroundColor")
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @JsonProperty("backgroundColorId")
    public Long getBackgroundColorId() {
        return backgroundColorId;
    }

    @JsonProperty("backgroundColorId")
    public void setBackgroundColorId(Long backgroundColorId) {
        this.backgroundColorId = backgroundColorId;
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
