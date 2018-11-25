package nearbyshops.user.service.impl;

import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.User;
import nearbyshops.user.repository.DislikedShopRepository;
import nearbyshops.user.repository.PreferredShopRepository;
import nearbyshops.user.repository.UserRepository;
import nearbyshops.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static java.lang.Math.abs;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DislikedShopRepository dislikedShopRepository;

    @Autowired
    PreferredShopRepository preferredShopRepository;


    public User getUserById(long id) {
        User user = userRepository.findUserById(id);
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return null;
    }

    public List<PreferredShop> getUserPrefferedShops(long id) {
        User user = getUserById(id);
        return user.getPreferredShops();
    }


    public boolean addUser(String email,String password) {
        if (isUserExist(email)){
            return false;
        }

        User user = new User(email,password);
        userRepository.save(user);
        return true;
    }

    public boolean removeUser(long id) {
        userRepository.deleteById(id);
        return true;
    }


    public boolean addShopToUserPrefferedShops(long user_id, String shop_id) {
        User user = getUserById(user_id);

        PreferredShop preferredShop = new PreferredShop();
        preferredShop.setShop_id(shop_id);

        user.addPrefferedShop(preferredShop);
        preferredShopRepository.save(preferredShop);

        return true;
    }


    public boolean removeShopFromUserPrefferedShops(long user_id, long shop_id) {
        // shop_id here is the id of the row in the prefferedshop table

        User user = getUserById(user_id);

        PreferredShop preferredShop = preferredShopRepository.findPreferredShopById(shop_id);

        user.removePrefferedShop(preferredShop);
        preferredShopRepository.delete(preferredShop);
        return true;
    }


    public boolean addShopToUserDislikedShops(long user_id, String shop_id) {
        User user = getUserById(user_id);

        DislikedShop dislikedShop = new DislikedShop();
        dislikedShop.setShop_id(shop_id);
        dislikedShop.setDislikingTime(new Date()); // setting current time

        user.addDislikedShop(dislikedShop);
        dislikedShopRepository.save(dislikedShop);
        return true;
    }

    // get updated disliked shops list based on how much time passed since the user disliked each shop in the list
    public List<DislikedShop> updatedUserDislikedShops(long user_id) {
        User user = getUserById(user_id);
        Date currentDateTime = new Date();
        long threshold = 2; // in hours
        long diffHours;

        for(DislikedShop dislikedShop : user.getDislikedShops()){
            diffHours = abs(dislikedShop.getDislikingTime().getTime() - currentDateTime.getTime()); // in milliseconds
            diffHours = diffHours/(1000*60*60); // in hours

            if(diffHours > threshold){
                user.removeDislikedShop(dislikedShop);
                dislikedShopRepository.delete(dislikedShop);
            }

        }
        return user.getDislikedShops();
    }

    public boolean isUserExist(String email) {
        if (getUserByEmail(email)==null){
            return false;
        }
        return true;
    }
}
