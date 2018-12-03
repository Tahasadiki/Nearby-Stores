package nearbyshops.user.controller;


import nearbyshops.user.dto.ShopDTO;
import nearbyshops.user.entity.User;
import nearbyshops.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/")
    public String getIndex(@RequestParam(name="lat",required = false) Double lat, @RequestParam(name="lon",required = false) Double lon, Model model, Principal principal) {

        if (principal == null) {
            model.addAttribute("user", new User());
            return "login";
        }

        if(lat==null || lon==null){
            model.addAttribute("positionExist",false);
            return "index";
        }

        listNearbyShops(lat,lon,model,principal);
        listPreferredShops(model,principal);

        return "index";
    }

    @PostMapping("/")
    public String postIndex(@RequestParam(name="lat") Double lat, @RequestParam(name="lon") Double lon, Model model, Principal principal){
        return getIndex(lat,lon,model,principal);
    }

    @PostMapping(value = "/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model,Principal principal,@RequestParam(name="lat",required = false) Double lat, @RequestParam(name="lon",required = false) Double lon){

        boolean userExist = userService.isEmailExist(user.getEmail());
        if (userExist){
            model.addAttribute("registerError",true);
            model.addAttribute("errorMsg","Email already exist");
            return getIndex(lat,lon,model,principal);
        }

        if( bindingResult.hasErrors()){
            model.addAttribute("registerError",true);
            model.addAttribute("errorMsg","Email not valid Or password less than 4 characters");
            return getIndex(lat,lon,model,principal);
        }

        userService.addUser(user);
        model.addAttribute("registrationSuccess",true);
        return getIndex(lat,lon,model,principal);
    }

    @GetMapping("/login")
    public String getLogInForm( Model model,Principal principal,@RequestParam(name="lat",required = false) Double lat, @RequestParam(name="lon",required = false) Double lon){
        return getIndex(lat,lon,model,principal);
    }

    @GetMapping("/preferredShops")
    public String listPreferredShops(Model model,Principal principal){
        String email = principal.getName();
        User user = userService.getUserByEmail(email);
        model.addAttribute("preferredShops",userService.getUserPreferredShops(user));
        return "index";
    }

    @PostMapping("/removePreferredShop")
    public String removePreferredShop(@RequestParam("id") long id, Model model,Principal principal,@RequestParam(name="lat",required = false) Double lat, @RequestParam(name="lon",required = false) Double lon ){
        String email = principal.getName();
        User user = userService.getUserByEmail(email);

        userService.removeShopFromUserPreferredShops(user,id);

        model.addAttribute("preferredShopsTab",true); // Go to the tab of preferred shops

        return getIndex(lat,lon,model,principal);
    }

    @GetMapping("/nearbyShops")
    public String listNearbyShops(Double lat,Double lon,Model model, Principal principal){

        String email = principal.getName();
        User user = userService.getUserByEmail(email);

        //all the nearby shops from the shopService

        String url = "http://localhost:9001/$lat=" + lat + "$lon=" + lon +"$radius=1000/nearbyShops";   // radius == 1000 m
        ResponseEntity<List<ShopDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<ShopDTO>>() {});

        List<ShopDTO> shops = responseEntity.getBody();

        // eliminating preferred and disliked shops
        shops = userService.filterUserNearbyShops(user,shops);

        model.addAttribute("shops",shops); // the list of shops to display

        model.addAttribute("shopDTO", new ShopDTO()); // the model which will be sent by the form to add a new preferred/disliked shop


        return "index";
    }

    @PostMapping("/like")
    public String addShopToUserPreferredShops(@ModelAttribute("shopDTO") ShopDTO shop, Model model ,Principal principal,@RequestParam(name="lat",required = false) Double lat, @RequestParam(name="lon",required = false) Double lon){

        String email = principal.getName();
        User user = userService.getUserByEmail(email);

        userService.addShopToUserPreferredShops(user,shop);

        return getIndex(lat,lon,model,principal);
    }

    @PostMapping("/dislike")
    public String addShopToUserDislikedShops(@ModelAttribute("shopDTO") ShopDTO shop,Model model, Principal principal,@RequestParam(name="lat",required = false) Double lat, @RequestParam(name="lon",required = false) Double lon){

        String email = principal.getName();
        User user = userService.getUserByEmail(email);

        userService.addShopToUserDislikedShops(user,shop);

        return getIndex(lat,lon,model,principal);
    }


}
