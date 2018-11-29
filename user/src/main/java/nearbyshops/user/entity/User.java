package nearbyshops.user.entity;



import nearbyshops.user.dto.RoleDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users") // in order to avoid the reserved word "user"
public class User{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    @Size(min=4)
    private String password;



    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<PreferredShop> preferredShops = new ArrayList<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<DislikedShop> dislikedShops = new ArrayList<>();


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();




    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public User(User user){
        setDislikedShops(user.getDislikedShops());
        setEmail(user.getEmail());
        setId(user.getId());
        setPassword(user.getPassword());
        setPreferredShops(user.getPreferredShops());
        setRoles(user.getRoles());
    }


    // add shop to user preffered shops
    public void addPreferredShop(PreferredShop prefferedshop){
        this.preferredShops.add(prefferedshop);
        prefferedshop.setUser(this);
    }

    // remove shop from user preffered shops
    public void removePreferredShop(PreferredShop preferredShop) {
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


    // add Roles
    public void addRole(Role role){
        this.roles.add(role);
        role.getUsers().add(this);
    }

    // remove role
    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

