package nearbyshops.user.dto;


import java.util.ArrayList;
import java.util.List;

public class RoleDTO {

    private long id;
    private String role;
    private List<Long> users = new ArrayList<>();

    public RoleDTO(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public RoleDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Long> getUsers() {
        return users;
    }

    public void setUsers(List<Long> users) {
        this.users = users;
    }
}
