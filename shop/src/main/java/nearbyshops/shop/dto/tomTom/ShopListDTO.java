package nearbyshops.shop.dto.tomTom;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopListDTO {

    @JsonProperty(
            value = "summary",
            required = true
    )
    private Summary summary;

    @JsonProperty(
            value = "results",
            required = true
    )
    private List<Result> results;




    public ShopListDTO() {
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
