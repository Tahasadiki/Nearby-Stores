package nearbyshops.user.service.impl;

import nearbyshops.user.dto.*;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.Role;
import nearbyshops.user.entity.User;
import nearbyshops.user.mapper.Mapper;
import nearbyshops.user.repository.DislikedShopRepository;
import nearbyshops.user.repository.PreferredShopRepository;
import nearbyshops.user.repository.RoleRepository;
import nearbyshops.user.repository.UserRepository;
import nearbyshops.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Math.abs;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DislikedShopRepository dislikedShopRepository;

    @Autowired
    PreferredShopRepository preferredShopRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    Mapper mapper;


    public User getUserById(long id) {
        User user = userRepository.findUserById(id);
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }

    public List<PreferredShopDTO> getUserPreferredShops(long id) {
        List<PreferredShopDTO> preferredShopsDTO;
        preferredShopsDTO = mapper.map(getUserById(id).getPreferredShops());
        return preferredShopsDTO;
    }


    public boolean addUser(UserDetailsModel userDetailsModel) {
        if (isUserExist(userDetailsModel.getEmail())){
            return false;
        }


        User user = mapper.map(userDetailsModel);
        Role role = new Role("USER");
        user.addRole(role);

        roleRepository.save(role);
        userRepository.save(user);
        return true;

    }

    public boolean removeUser(long id) {
        userRepository.deleteById(id);
        return true;
    }

    public boolean addRole(Role role){
        if (roleRepository.findRoleByRole(role.getRole())==null){
            Role newRole = new Role(role.getRole());
            roleRepository.save(newRole);
        }
        return true;
    }

    @Override
    public UserDetailsModel getUserDetailsById(long id) {
        User user = getUserById(id);
        UserDetailsModel userDetails = new UserDetailsModel();

        List<RoleDTO> rolesDTO = new ArrayList<>();

        userDetails.setPassword(user.getPassword());
        userDetails.setEmail(user.getEmail());
        userDetails.setRoles(mapper.map(user.getRoles(),rolesDTO));
        return userDetails;
    }

    @Override
    public UserDetailsModel getUserDetailsByEmail(String email) {
        User user = getUserByEmail(email);
        UserDetailsModel userDetails = new UserDetailsModel();

        List<RoleDTO> rolesDTO = new ArrayList<>();

        userDetails.setRoles(mapper.map(user.getRoles(),rolesDTO));
        userDetails.setEmail(user.getEmail());
        userDetails.setPassword(user.getPassword());

        return userDetails;
    }

    public boolean addShopToUserPreferredShops(long user_id, ShopDTO shop) {
        User user = getUserById(user_id);

        PreferredShop preferredShop = mapper.map(shop, new PreferredShop());

        user.addPreferredShop(preferredShop);
        preferredShopRepository.save(preferredShop);

        return true;
    }


    public boolean removeShopFromUserPreferredShops(long user_id, long shop_id) {
        // shop_id here is the id of the row in the preferredShops table

        User user = getUserById(user_id);

        PreferredShop preferredShop = preferredShopRepository.findPreferredShopById(shop_id);

        user.removePreferredShop(preferredShop);
        preferredShopRepository.delete(preferredShop);
        return true;
    }


    public boolean addShopToUserDislikedShops(long user_id, ShopDTO shop) {
        User user = getUserById(user_id);

        DislikedShop dislikedShop = mapper.map(shop, new DislikedShop());
        dislikedShop.setDislikingTime(new Date()); // dislikingTime = current time

        user.addDislikedShop(dislikedShop);
        dislikedShopRepository.save(dislikedShop);
        return true;
    }

    // get updated disliked shops list based on how much time passed since the user disliked each shop in the list
    public List<DislikedShopDTO> updatedUserDislikedShops(long user_id) {
        List<DislikedShopDTO> dislikedShopsDTO = new ArrayList<>();

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
            }else{
                dislikedShopsDTO.add(mapper.map(dislikedShop));
            }

        }
        return dislikedShopsDTO;
    }


    public boolean isUserExist(String email) {
        if (getUserByEmail(email)==null){
            return false;
        }
        return true;
    }

}
