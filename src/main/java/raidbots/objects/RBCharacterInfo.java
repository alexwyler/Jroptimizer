package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import util.JacksonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by alexwyler on 2/14/19.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RBCharacterInfo {

    public List<RBClassInfo>                    classes;
    public Map<String, Map<String, RBSpecInfo>> specInfo;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RBSpecInfo {
        public String name;
        public Long id;
        public String mainStat;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RBClassInfo {
        public long id;
        public String name;
    }

    public static RBCharacterInfo info;
    static {
        try {
            info = JacksonUtil.read(FileUtils.readFileToString(new File("data/raidbots-character.json")), RBCharacterInfo.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long specIdForName(String _class, String name) {
        return info.specInfo.get(_class).get(StringUtils.lowerCase(name).replaceAll("\\s", "_")).id;
    }

    public static String classNameForId(long id) {
        for (RBClassInfo classInfo : info.classes) {
            if (classInfo.id == id) {
                return classInfo.name;
            }
        }
        return null;
    }
}
