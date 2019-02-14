package raidbots.objects;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "averageItemLevel",
        "averageItemLevelEquipped",
        "head",
        "neck",
        "shoulder",
        "back",
        "chest",
        "wrist",
        "hands",
        "waist",
        "legs",
        "feet",
        "finger1",
        "finger2",
        "trinket1",
        "trinket2",
        "mainHand",
        "offHand"
})
public class Items {

    @JsonProperty("averageItemLevel")
    private Long     averageItemLevel;
    @JsonProperty("averageItemLevelEquipped")
    private Long     averageItemLevelEquipped;
    @JsonProperty("head")
    private Head     head;
    @JsonProperty("neck")
    private Neck     neck;
    @JsonProperty("shoulder")
    private Shoulder shoulder;
    @JsonProperty("back")
    private Back     back;
    @JsonProperty("chest")
    private Chest    chest;
    @JsonProperty("wrist")
    private Wrist    wrist;
    @JsonProperty("hands")
    private Hands    hands;
    @JsonProperty("waist")
    private Waist    waist;
    @JsonProperty("legs")
    private Legs     legs;
    @JsonProperty("feet")
    private Feet     feet;
    @JsonProperty("finger1")
    private Finger1  finger1;
    @JsonProperty("finger2")
    private Finger2  finger2;
    @JsonProperty("trinket1")
    private Trinket1 trinket1;
    @JsonProperty("trinket2")
    private Trinket2 trinket2;
    @JsonProperty("mainHand")
    private MainHand mainHand;
    @JsonProperty("offHand")
    private OffHand  offHand;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("averageItemLevel")
    public Long getAverageItemLevel() {
        return averageItemLevel;
    }

    @JsonProperty("averageItemLevel")
    public void setAverageItemLevel(Long averageItemLevel) {
        this.averageItemLevel = averageItemLevel;
    }

    @JsonProperty("averageItemLevelEquipped")
    public Long getAverageItemLevelEquipped() {
        return averageItemLevelEquipped;
    }

    @JsonProperty("averageItemLevelEquipped")
    public void setAverageItemLevelEquipped(Long averageItemLevelEquipped) {
        this.averageItemLevelEquipped = averageItemLevelEquipped;
    }

    @JsonProperty("head")
    public Head getHead() {
        return head;
    }

    @JsonProperty("head")
    public void setHead(Head head) {
        this.head = head;
    }

    @JsonProperty("neck")
    public Neck getNeck() {
        return neck;
    }

    @JsonProperty("neck")
    public void setNeck(Neck neck) {
        this.neck = neck;
    }

    @JsonProperty("shoulder")
    public Shoulder getShoulder() {
        return shoulder;
    }

    @JsonProperty("shoulder")
    public void setShoulder(Shoulder shoulder) {
        this.shoulder = shoulder;
    }

    @JsonProperty("back")
    public Back getBack() {
        return back;
    }

    @JsonProperty("back")
    public void setBack(Back back) {
        this.back = back;
    }

    @JsonProperty("chest")
    public Chest getChest() {
        return chest;
    }

    @JsonProperty("chest")
    public void setChest(Chest chest) {
        this.chest = chest;
    }

    @JsonProperty("wrist")
    public Wrist getWrist() {
        return wrist;
    }

    @JsonProperty("wrist")
    public void setWrist(Wrist wrist) {
        this.wrist = wrist;
    }

    @JsonProperty("hands")
    public Hands getHands() {
        return hands;
    }

    @JsonProperty("hands")
    public void setHands(Hands hands) {
        this.hands = hands;
    }

    @JsonProperty("waist")
    public Waist getWaist() {
        return waist;
    }

    @JsonProperty("waist")
    public void setWaist(Waist waist) {
        this.waist = waist;
    }

    @JsonProperty("legs")
    public Legs getLegs() {
        return legs;
    }

    @JsonProperty("legs")
    public void setLegs(Legs legs) {
        this.legs = legs;
    }

    @JsonProperty("feet")
    public Feet getFeet() {
        return feet;
    }

    @JsonProperty("feet")
    public void setFeet(Feet feet) {
        this.feet = feet;
    }

    @JsonProperty("finger1")
    public Finger1 getFinger1() {
        return finger1;
    }

    @JsonProperty("finger1")
    public void setFinger1(Finger1 finger1) {
        this.finger1 = finger1;
    }

    @JsonProperty("finger2")
    public Finger2 getFinger2() {
        return finger2;
    }

    @JsonProperty("finger2")
    public void setFinger2(Finger2 finger2) {
        this.finger2 = finger2;
    }

    @JsonProperty("trinket1")
    public Trinket1 getTrinket1() {
        return trinket1;
    }

    @JsonProperty("trinket1")
    public void setTrinket1(Trinket1 trinket1) {
        this.trinket1 = trinket1;
    }

    @JsonProperty("trinket2")
    public Trinket2 getTrinket2() {
        return trinket2;
    }

    @JsonProperty("trinket2")
    public void setTrinket2(Trinket2 trinket2) {
        this.trinket2 = trinket2;
    }

    @JsonProperty("mainHand")
    public MainHand getMainHand() {
        return mainHand;
    }

    @JsonProperty("mainHand")
    public void setMainHand(MainHand mainHand) {
        this.mainHand = mainHand;
    }

    @JsonProperty("offHand")
    public OffHand getOffHand() {
        return offHand;
    }

    @JsonProperty("offHand")
    public void setOffHand(OffHand offHand) {
        this.offHand = offHand;
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
