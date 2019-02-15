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
public class SItem {

    public static List<SItem> items;
    static {
        try {
            items = JacksonUtil.readList(FileUtils.readFileToString(new File("data/encounter-items-live.json")), SItem.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SItem getItem(long itemId) {
        for (SItem item : items) {
            if (item.id == itemId) {
                return item;
            }
        }
        return null;
    }

    public Long              id;
    public String            name;
    public String            icon;
    public Long              itemLevel;
    public List<SItemSource> sources;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SItemSource {
        public Long instanceId;
        public Long encounterId;
    }
}
