package nearbyshops.user.entity;

import javax.persistence.*;
import java.util.Date;

@Entity

public class DislikedShop {

    @Id
    @GeneratedValue
    private long id;

    private String shop_id;
    private Date dislikingTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;


    public DislikedShop() {
    }

    public DislikedShop(String shop_id, Date dislikingTime, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
