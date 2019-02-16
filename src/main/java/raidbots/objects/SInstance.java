package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.io.FileUtils;
import util.JacksonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexwyler on 2/15/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SInstance {

    public static List<SInstance> instances;
    static {
        try {
            instances = JacksonUtil.readList(FileUtils.readFileToString(new File("data/instances-live.json")), SInstance.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static SEncounter getEncounter(long id) {
        for (SInstance instance : instances) {
            for (SEncounter encounter : instance.encounters) {
                if (encounter.id == id) {
                    return encounter;
                }
            }
        }
        return null;
    }

    public static SInstance getInstanceForName(String name) {
        for (SInstance instance : instances) {
            if (instance.name.equals(name)) {
                return instance;
            }
        }
        return null;
    }

    public Long              id;
    public String            name;
    public String            type;
    public List<SEncounter> encounters;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SEncounter {
        public Long              id;
        public String            name;
        public String            icon;
    }
}
