package nearbyshops.shop.service.impl;


import nearbyshops.shop.dto.ShopDTO;
import nearbyshops.shop.dto.tomTom.ShopListDTO;
import nearbyshops.shop.mapper.Mapper;
import nearbyshops.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service

public class ShopServiceImpl implements ShopService {


    // pre-configuration
    private String apiKey = "k9fpNAlSWSKYn7duXFrIALVJGFRQczA2"; // my TomTom search api key
    private String keyWord = "shop"; // search key word


    @Autowired
    RestTemplate restTemplate; // to communicate with services registered with eureka

    RestTemplate restTemplateTom = new RestTemplate(); // to communicate with TomTom api

    @Autowired
    Mapper mapper;

    public List<ShopDTO> getNearbyShops(double lat, double lon, long radius) {

        String query = String.format("https://api.tomtom.com/search/2/search/%s.json?key=%s&lat=%f&lon=%f&radius=%d",
                keyWord,
                apiKey,
                lat,
                lon,
                radius);

        ShopListDTO results = restTemplateTom.getForObject(query,ShopListDTO.class);

        List<ShopDTO> shops = mapper.map(results);
        
        return shops;
    }
}
