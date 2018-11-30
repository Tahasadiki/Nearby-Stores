package nearbyshops.user.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsModel {

    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    private List<RoleDTO> roles = new ArrayList<>();


    public UserDetailsModel() {
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

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}
