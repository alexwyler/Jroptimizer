package raidbots.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by alexwyler on 2/14/19.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SSimData {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SSim {
        public List<SSimPlayer> players;
        public SProfileSets profilesets;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SSimPlayer {
        public SSimCollectedData collected_data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SSimCollectedData {
        public SMetric dpse;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SMetric {
        public double mean;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SProfileSets {
        public String metric;
        public List<SProfileSetResult> results;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SProfileSetResult {
        public String name;
        public double mean;
    }

    public SSim sim;
}
