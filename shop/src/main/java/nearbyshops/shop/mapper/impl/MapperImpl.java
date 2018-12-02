package nearbyshops.shop.mapper.impl;


import nearbyshops.shop.dto.ShopDTO;
import nearbyshops.shop.dto.tomTom.Result;
import nearbyshops.shop.dto.tomTom.ShopListDTO;
import nearbyshops.shop.mapper.Mapper;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


@Component
public class MapperImpl implements Mapper {


    public List<ShopDTO> map(ShopListDTO shopListDTO) {
        List<ShopDTO> shops = new ArrayList<>();


        for(Result result : shopListDTO.getResults()){
            ShopDTO shop = new ShopDTO();

            shop.setShop_id(result.getShop_id());
            shop.setName(result.getPoi().getName());
            shop.setPhone(result.getPoi().getPhone());
            shop.setUrl(result.getPoi().getUrl());
            shop.setScore(result.getScore());
            shop.setDist(result.getDist());
            shop.setLat(result.getPosition().getLat());
            shop.setLon(result.getPosition().getLon());
            shop.setAddress(result.getAddress().getAddress());
            shop.setCategories(result.getPoi().getCategories());
            shop.setImgUrl("");

            // adding the result to the new shop list
            shops.add(shop);

        }

        return shops;
    }
}
