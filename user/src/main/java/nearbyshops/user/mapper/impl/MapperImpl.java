package nearbyshops.user.mapper.impl;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
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
}
