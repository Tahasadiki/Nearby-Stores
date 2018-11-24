package nearbyshops.user.controller;

import io.swagger.annotations.Api;
import nearbyshops.user.service.UserService;
import nearbyshops.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags="User")

public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

}
