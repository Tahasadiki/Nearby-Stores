package nearbyshops.shop.dto.tomTom;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

    @JsonProperty(
            value = "numResults",
            required = true
    )
    private long numResults;

    @JsonProperty(
            value = "queryTime",
            required = true
    )
    private long queryTime;

    public Summary() {
    }

    public long getNumResults() {
        return numResults;
    }

    public void setNumResults(long numResults) {
        this.numResults = numResults;
    }

    public long getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(long queryTime) {
        this.queryTime = queryTime;
    }
}
