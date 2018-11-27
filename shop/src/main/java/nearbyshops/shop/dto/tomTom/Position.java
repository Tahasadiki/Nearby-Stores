package nearbyshops.shop.dto.tomTom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {

    @JsonProperty(
            value = "lat",
            required = true
    )
    private double lat;

    @JsonProperty(
            value = "lon",
            required = true
    )
    private double lon;



    public Position() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
