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
    public List<PreferredShopDTO> getUserPreferredShops(long id);
    public boolean isUserExist(String email);
    public boolean addUser(UserDetailsModel userDetailsModel);
    public boolean removeUser(long id);
    public boolean addShopToUserPreferredShops(long user_id, ShopDTO shop);
    public boolean removeShopFromUserPreferredShops(long user_id,long shop_id);
    public boolean addShopToUserDislikedShops(long user_id,ShopDTO shop);
    public List<DislikedShopDTO> updatedUserDislikedShops(long user_id);
    public boolean addRole(Role role);
    public UserDetailsModel getUserDetailsById(long id);

    UserDetailsModel getUserDetailsByEmail(String email);
}
