package nearbyshops.shop.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nearbyshops.shop.dto.ShopDTO;
import nearbyshops.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@Api(tags = "Shop")

public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/$lat={lat}$lon={lon}$radius={radius}/nearbyShops")
    @ApiOperation("Get the list of nearby shops")
    public List<ShopDTO> getNearbyShops(@PathVariable("lat") double lat, @PathVariable("lon") double lon, @PathVariable("radius") long radius){
        return shopService.getNearbyShops(lat, lon, radius);
    }



}
