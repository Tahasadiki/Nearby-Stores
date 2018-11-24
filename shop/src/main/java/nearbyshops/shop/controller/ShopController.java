package nearbyshops.shop.controller;


import io.swagger.annotations.Api;
import nearbyshops.shop.service.ShopService;
import nearbyshops.shop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
@Api(tags = "Shop")

public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    ShopRepository shopRepository;



}
