package battlenet.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by alexwyler on 2/15/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SGuild {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SMemberCharacter {
        public String name;
        public Long level;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SMember {
        public SMemberCharacter character;
        public Long rank;
    }

    public String name;
    public List<SMember> members;
}
