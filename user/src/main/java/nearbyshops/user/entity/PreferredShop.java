package nearbyshops.user.entity;

import javax.persistence.*;

@Entity

public class PreferredShop {

    @Id
    @GeneratedValue
    private long id;

    private String shop_id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

    public PreferredShop() {
    }

    public PreferredShop(String shop_id, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
