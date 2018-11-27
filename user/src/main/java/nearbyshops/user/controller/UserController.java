package nearbyshops.user.controller;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
import nearbyshops.user.dto.ShopDTO;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.User;
import nearbyshops.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags="User")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/$id={user_id}")
    @ApiOperation("Get user by id")
    public User getUserById(@PathVariable("user_id") long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/$email={user_email}")
    @ApiOperation("Get user by email")
    public User getUserByEmail(@PathVariable("user_email") String email){
        User user = userService.getUserByEmail(email);
        return user;
    }

    @GetMapping("/$id={user_id}/preferredShops")
    @ApiOperation("Get user preferred shops")
    public List<PreferredShopDTO> getUserPreferredShops(@PathVariable("user_id") long id){
        List<PreferredShopDTO> preferredShopsDTO = userService.getUserPreferredShops(id);
        return preferredShopsDTO;
    }

    @GetMapping("/$id={user_id}/dislikedShops")
    @ApiOperation("Get user disliked shops list")
    public List<DislikedShopDTO> getUserDislikedShops(@PathVariable("user_id") long id){
        List<DislikedShopDTO> dislikedShopsDTO = userService.updatedUserDislikedShops(id);
        return dislikedShopsDTO;
    }

    @PostMapping("/addUser")
    @ApiOperation("Add new user")
    public boolean addUser(@RequestBody String email,@RequestBody String password){
        return userService.addUser(email,password);
    }

    @PutMapping("/addPreferredShop/$user_id{user_id}")
    @ApiOperation("Add shop to user preferred shops list")
    public boolean addShopToUserPreferredShops(@PathVariable("user_id") long user_id, @RequestBody ShopDTO shop){
        return userService.addShopToUserPreferredShops(user_id,shop);
    }

    @PutMapping("/removePreferredShop/$user_id{user_id}$shop_id{shop_id}")
    @ApiOperation("Remove shop from user preferred shops list")
    public boolean removeShopFromUserPreferredShops(@PathVariable("user_id") long user_id,@PathVariable("shop_id") long shop_id){
        return userService.removeShopFromUserPreferredShops(user_id,shop_id);
    }

    @PutMapping("/addDislikedShop/$user_id{user_id}$shop_id{shop_id}")
    @ApiOperation("Add shop to user disliked shops list")
    public boolean addShopToUserDislikedShops(@PathVariable("user_id") long user_id,@PathVariable("shop_id") String shop_id){
        return userService.addShopToUserDislikedShops(user_id,shop_id);
    }




}
