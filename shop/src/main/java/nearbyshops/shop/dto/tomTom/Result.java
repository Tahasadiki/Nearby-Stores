package nearbyshops.shop.dto.tomTom;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty(
            value = "id",
            required = true
    )
    private String shop_id;

    @JsonProperty(
            value = "score"
    )
    private long score;

    @JsonProperty(
            value = "dist",
            required = true
    )
    private long dist;

    @JsonProperty(
            value = "poi",
            required = true
    )
    private Poi poi;

    @JsonProperty(
            value = "address",
            required = true
    )
    private Address address;

    @JsonProperty(
            value = "position",
            required = true
    )
    private Position position;


    public Result() {
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getDist() {
        return dist;
    }

    public void setDist(long dist) {
        this.dist = dist;
    }

    public Poi getPoi() {
        return poi;
    }

    public void setPoi(Poi poi) {
        this.poi = poi;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
