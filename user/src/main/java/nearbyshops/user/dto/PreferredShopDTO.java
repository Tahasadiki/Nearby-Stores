package nearbyshops.user.dto;



public class PreferredShopDTO {

    private long id;

    private String shop_id;

    private long user;

    public PreferredShopDTO() {
    }

    public PreferredShopDTO(String shop_id, long user) {
        this.shop_id = shop_id;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

}
