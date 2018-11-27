package nearbyshops.user.mapper.impl;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
import nearbyshops.user.dto.ShopDTO;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.mapper.Mapper;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MapperImpl implements Mapper {


    public DislikedShopDTO map(DislikedShop dislikedShop){
        DislikedShopDTO dislikedShopDTO = new DislikedShopDTO();

        dislikedShopDTO.setId(dislikedShop.getId());
        dislikedShopDTO.setShop_id(dislikedShop.getShop_id());
        dislikedShopDTO.setDislikingTime(dislikedShop.getDislikingTime());
        dislikedShopDTO.setUser(dislikedShop.getUser().getId());

        return dislikedShopDTO;
    }


    public PreferredShopDTO map(PreferredShop preferredShop){
        PreferredShopDTO preferredShopDTO = new PreferredShopDTO();

        preferredShopDTO.setId(preferredShop.getId());
        preferredShopDTO.setShop_id(preferredShop.getShop_id());
        preferredShopDTO.setUser(preferredShop.getUser().getId());

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
}
