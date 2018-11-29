package nearbyshops.user.mapper.impl;


import nearbyshops.user.dto.*;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.Role;
import nearbyshops.user.entity.User;
import nearbyshops.user.mapper.Mapper;
import nearbyshops.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

@Component
public class MapperImpl implements Mapper {
    @Autowired
    UserRepository userRepository;

    public DislikedShopDTO map(DislikedShop dislikedShop){
        DislikedShopDTO dislikedShopDTO = new DislikedShopDTO();

        dislikedShopDTO.setId(dislikedShop.getId());
        dislikedShopDTO.setShop_id(dislikedShop.getShop_id());
        dislikedShopDTO.setDislikingTime(dislikedShop.getDislikingTime());
        dislikedShopDTO.setUser(dislikedShop.getUser().getId());
        dislikedShopDTO.setAddress(dislikedShop.getAddress());
        dislikedShopDTO.setCategories(dislikedShop.getCategories());
        dislikedShopDTO.setDist(dislikedShop.getDist());
        dislikedShopDTO.setLat(dislikedShop.getLat());
        dislikedShopDTO.setLon(dislikedShop.getLon());
        dislikedShopDTO.setImgUrl(dislikedShop.getImgUrl());
        dislikedShopDTO.setName(dislikedShop.getName());
        dislikedShopDTO.setPhone(dislikedShop.getPhone());
        dislikedShopDTO.setScore(dislikedShop.getScore());

        return dislikedShopDTO;
    }


    public PreferredShopDTO map(PreferredShop preferredShop){
        PreferredShopDTO preferredShopDTO = new PreferredShopDTO();

        preferredShopDTO.setId(preferredShop.getId());
        preferredShopDTO.setShop_id(preferredShop.getShop_id());
        preferredShopDTO.setUser(preferredShop.getUser().getId());
        preferredShopDTO.setAddress(preferredShop.getAddress());
        preferredShopDTO.setCategories(preferredShop.getCategories());
        preferredShopDTO.setDist(preferredShop.getDist());
        preferredShopDTO.setLat(preferredShop.getLat());
        preferredShopDTO.setLon(preferredShop.getLon());
        preferredShopDTO.setImgUrl(preferredShop.getImgUrl());
        preferredShopDTO.setName(preferredShop.getName());
        preferredShopDTO.setPhone(preferredShop.getPhone());
        preferredShopDTO.setScore(preferredShop.getScore());

        return preferredShopDTO;
    }




    public List<PreferredShopDTO> map(List<PreferredShop> preferredShops){
        List<PreferredShopDTO> preferredShopsDTO = new ArrayList<>();

        for(PreferredShop preferredShop : preferredShops){
            preferredShopsDTO.add(map(preferredShop));
        }

        return preferredShopsDTO;

    }


    public PreferredShop map(ShopDTO shop,PreferredShop preferredShop) {

        preferredShop.setAddress(shop.getAddress());
        preferredShop.setShop_id(shop.getShop_id());
        preferredShop.setName(shop.getName());
        preferredShop.setScore(shop.getScore());
        preferredShop.setUrl(shop.getUrl());
        preferredShop.setDist(shop.getDist());
        preferredShop.setLat(shop.getLat());
        preferredShop.setLon(shop.getLon());
        preferredShop.setCategories(shop.getCategories());
        preferredShop.setImgUrl(shop.getImgUrl());


        return preferredShop;
    }

    public DislikedShop map(ShopDTO shop,DislikedShop dislikedShop) {

        dislikedShop.setAddress(shop.getAddress());
        dislikedShop.setShop_id(shop.getShop_id());
        dislikedShop.setName(shop.getName());
        dislikedShop.setScore(shop.getScore());
        dislikedShop.setUrl(shop.getUrl());
        dislikedShop.setDist(shop.getDist());
        dislikedShop.setLat(shop.getLat());
        dislikedShop.setLon(shop.getLon());
        dislikedShop.setCategories(shop.getCategories());
        dislikedShop.setImgUrl(shop.getImgUrl());


        return dislikedShop;
    }


    public User map(UserDetailsModel userDetailsModel) {
        User user = new User();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(userDetailsModel.getPassword()));

        user.setEmail(userDetailsModel.getEmail());


        List<Role> roles = new ArrayList<>();
        for(RoleDTO roleDTO:userDetailsModel.getRoles()){
            roles.add(map(roleDTO));
        }
        user.setRoles(roles);

        return user;
    }


    public RoleDTO map(Role role) {
        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId(role.getId());
        roleDTO.setRole(role.getRole());

        List<Long> users = new ArrayList<>();
        for(User user:role.getUsers()){
            users.add(user.getId());
        }
        roleDTO.setUsers(users);

        return roleDTO;
    }


    public List<RoleDTO> map(List<Role> roles,List<RoleDTO> rolesDTO) {
        for(Role role : roles){
            rolesDTO.add(map(role));
        }

        return rolesDTO;
    }


    public Role map(RoleDTO roleDTO) {
        Role role = new Role();

        role.setId(roleDTO.getId());
        role.setRole(roleDTO.getRole());

        List<User> users = new ArrayList<>();
        for (Long user_id:roleDTO.getUsers()){
            users.add(userRepository.findUserById(user_id));
        }
        role.setUsers(users);

        return role;
    }

}
