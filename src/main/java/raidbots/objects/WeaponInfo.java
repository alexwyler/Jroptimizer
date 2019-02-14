package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "damage",
        "weaponSpeed",
        "dps"
})
public class WeaponInfo {

    @JsonProperty("damage")
    private Damage damage;
    @JsonProperty("weaponSpeed")
    private Double weaponSpeed;
    @JsonProperty("dps")
    private Double dps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("damage")
    public Damage getDamage() {
        return damage;
    }

    @JsonProperty("damage")
    public void setDamage(Damage damage) {
        this.damage = damage;
    }

    @JsonProperty("weaponSpeed")
    public Double getWeaponSpeed() {
        return weaponSpeed;
    }

    @JsonProperty("weaponSpeed")
    public void setWeaponSpeed(Double weaponSpeed) {
        this.weaponSpeed = weaponSpeed;
    }

    @JsonProperty("dps")
    public Double getDps() {
        return dps;
    }

    @JsonProperty("dps")
    public void setDps(Double dps) {
        this.dps = dps;
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
