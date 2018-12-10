package nearbyshops.shop.entity;


import java.util.List;

public class Shop {

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


}
