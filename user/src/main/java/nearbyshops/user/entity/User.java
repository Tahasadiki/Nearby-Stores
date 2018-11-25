package nearbyshops.user.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class User {

    @Id
    @GeneratedValue
    private long id;

    private String email;
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<PreferredShop> preferredShops = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<DislikedShop> dislikedShops = new ArrayList<>();

    public User(String email, String password, List<PreferredShop> preferredShops, List<DislikedShop> dislikedShops) {
        this.email = email;
        this.password = password;
        this.preferredShops = preferredShops;
        this.dislikedShops = dislikedShops;
    }


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {

    }


    // add shop to user preffered shops
    public void addPrefferedShop(PreferredShop prefferedshop){
        this.preferredShops.add(prefferedshop);
        prefferedshop.setUser(this);
    }

    // remove shop from user preffered shops
    public void removePrefferedShop(PreferredShop preferredShop) {
        this.preferredShops.remove(preferredShop);
    }

    //add shop to user disliked shops
    public void addDislikedShop(DislikedShop dislikedShop){
        this.dislikedShops.add(dislikedShop);
        dislikedShop.setUser(this);
    }

    // remove shop from user disliked shops
    public void removeDislikedShop(DislikedShop dislikedShop){
        this.dislikedShops.remove(dislikedShop);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PreferredShop> getPreferredShops() {
        return preferredShops;
    }

    public void setPreferredShops(List<PreferredShop> preferredShops) {
        this.preferredShops = preferredShops;
    }

    public List<DislikedShop> getDislikedShops() {
        return dislikedShops;
    }

    public void setDislikedShops(List<DislikedShop> dislikedShops) {
        this.dislikedShops = dislikedShops;
    }
}
