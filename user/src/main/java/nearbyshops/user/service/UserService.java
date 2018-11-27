package nearbyshops.user.service;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
import nearbyshops.user.dto.ShopDTO;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.User;

import java.util.List;

public interface UserService {

    public User getUserById(long id);
    public User getUserByEmail(String email);
    public List<PreferredShopDTO> getUserPreferredShops(long id);
    public boolean isUserExist(String email);
    public boolean addUser(String email,String password);
    public boolean removeUser(long id);
    public boolean addShopToUserPreferredShops(long user_id, ShopDTO shop);
    public boolean removeShopFromUserPreferredShops(long user_id,long shop_id);
    public boolean addShopToUserDislikedShops(long user_id,ShopDTO shop);
    public List<DislikedShopDTO> updatedUserDislikedShops(long user_id);

}
