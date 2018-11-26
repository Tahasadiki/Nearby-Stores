package nearbyshops.user.service;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.User;

import java.util.List;

public interface UserService {

    public User getUserById(long id);
    public User getUserByEmail(String email);
    public List<PreferredShopDTO> getUserPrefferedShops(long id);
    public boolean isUserExist(String email);
    public boolean addUser(String email,String password);
    public boolean removeUser(long id);
    public boolean addShopToUserPrefferedShops(long user_id,String shop_id);
    public boolean removeShopFromUserPrefferedShops(long user_id,long shop_id);
    public boolean addShopToUserDislikedShops(long user_id,String shop_id);
    public List<DislikedShopDTO> updatedUserDislikedShops(long user_id);

}
