package nearbyshops.user.dto;

import org.springframework.stereotype.Component;

import java.util.List;


public class ShopDTO {

    private String shop_id; // id provided by the TomTom search API (unstable)
    private String name;
    private String phone;
    private String url;
    private double score;
    private double dist;
    private double lat;   // latitude
    private double lon;   // longitude
    private String address;
    private List<String> categories;
    private String imgUrl;

    public ShopDTO() {
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopDTO shopDTO = (ShopDTO) o;

        if (Double.compare(shopDTO.lat, lat) != 0) return false;
        if (Double.compare(shopDTO.lon, lon) != 0) return false;
        if (!shop_id.equals(shopDTO.shop_id)) return false;
        return name.equals(shopDTO.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shop_id.hashCode();
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
