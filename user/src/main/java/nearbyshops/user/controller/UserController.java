package nearbyshops.user.controller;


import nearbyshops.user.entity.User;
import nearbyshops.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    @GetMapping("/signup")
    public String getSignUpForm(Model model) {

        model.addAttribute("user", new User());
        return "views/signupForm";
    }

    @PostMapping(value = "/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors()){
            return "views/signupForm";
        }

        boolean valid = userService.isEmailExist(user.getEmail());
        if (valid){
            model.addAttribute("userExist",true);
            return "views/signupForm";
        }
        userService.addUser(user);
        return "index";
    }

    @GetMapping("/login")
    public String getLogInForm(Model model){

        return "views/loginForm";
    }

    @GetMapping("/preferredShops")
    public String listPreferredShops(Model model){
        User user = userService.getUserById(1);
        model.addAttribute("preferredShops",userService.getUserPreferredShops(user));
        return "views/listPreferredShops";
    }

    @PostMapping("/removePreferredShop")
    public String removePreferredShop(long id){
        return "";
    }

    @GetMapping("/nearbyShops")
    public String listNearbyShops(Model model, Principal principal){

        String email = principal.getName();
        User user = userService.getUserByEmail(email);

        //all the nearby shops from the shopService

        // eliminating preferred and disliked shops

        return "views/nearbyShops";
    }


}
