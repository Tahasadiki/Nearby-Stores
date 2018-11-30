package nearbyshops.user.service;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
import nearbyshops.user.dto.ShopDTO;
import nearbyshops.user.dto.UserDetailsModel;
import nearbyshops.user.entity.Role;
import nearbyshops.user.entity.User;

import java.util.List;

public interface UserService {

    public User getUserById(long id);
    public User getUserByEmail(String email);
    public List<PreferredShopDTO> getUserPreferredShops(User user);
    public boolean isEmailExist(String email);
    public boolean addUser(User user);
    public boolean removeUser(long id);
    public boolean addShopToUserPreferredShops(User user, ShopDTO shop);
    public boolean removeShopFromUserPreferredShops(User user,long shop_id);
    public boolean addShopToUserDislikedShops(User user,ShopDTO shop);
    public List<DislikedShopDTO> updatedUserDislikedShops(User user);
    public boolean addRole(Role role);
    public UserDetailsModel getUserDetailsById(long id);

    UserDetailsModel getUserDetailsByEmail(String email);
}
