package nearbyshops.user.dto;


import java.util.Date;

public class DislikedShopDTO {

    private long id;

    private String shop_id;
    private Date dislikingTime;

    private long user;


    public DislikedShopDTO() {
    }

    public DislikedShopDTO(String shop_id, Date dislikingTime, long user) {
        this.shop_id = shop_id;
        this.dislikingTime = dislikingTime;
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

    public Date getDislikingTime() {
        return dislikingTime;
    }

    public void setDislikingTime(Date dislikingTime) {
        this.dislikingTime = dislikingTime;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }
}
