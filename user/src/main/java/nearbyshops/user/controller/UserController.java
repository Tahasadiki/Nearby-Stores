package nearbyshops.user.controller;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
import nearbyshops.user.dto.ShopDTO;
import nearbyshops.user.dto.UserDetailsModel;
import nearbyshops.user.entity.Role;
import nearbyshops.user.entity.User;
import nearbyshops.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags="User")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    @ApiOperation("Hello")
    public String getString() {
        return "Hello";
    }



    @GetMapping("/$id={user_id}")
    @ApiOperation("Get user details by id")
    public UserDetailsModel getUserDetailsById(@PathVariable("user_id") long id) {
        UserDetailsModel userDetails = userService.getUserDetailsById(id);
        return userDetails;
    }

    @GetMapping("/$email={user_email}")
    @ApiOperation("Get user details by email")
    public UserDetailsModel getUserDetailsByEmail(@PathVariable("user_email") String email){
        UserDetailsModel userDetails = userService.getUserDetailsByEmail(email);
        return userDetails;
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
    public boolean addUser(@RequestBody UserDetailsModel userDetailsModel){
        return userService.addUser(userDetailsModel);
    }

    @PostMapping("/addRole")
    @ApiOperation("Add new role")
    public boolean addUser(@RequestBody Role role){
        return userService.addRole(role);
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
    public boolean addShopToUserDislikedShops(@PathVariable("user_id") long user_id,@RequestBody ShopDTO shop){
        return userService.addShopToUserDislikedShops(user_id,shop);
    }




}
