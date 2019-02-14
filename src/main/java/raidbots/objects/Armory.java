package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "region",
        "realm",
        "name"
})
public class Armory {

    @JsonProperty("region")
    private String region;
    @JsonProperty("realm")
    private String realm;
    @JsonProperty("name")
    private String name;

    /**
     * No args constructor for use in serialization
     */
    public Armory() {
    }

    /**
     * @param region
     * @param realm
     * @param name
     */
    public Armory(String region, String realm, String name) {
        super();
        this.region = region;
        this.realm = realm;
        this.name = name;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("realm")
    public String getRealm() {
        return realm;
    }

    @JsonProperty("realm")
    public void setRealm(String realm) {
        this.realm = realm;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}
