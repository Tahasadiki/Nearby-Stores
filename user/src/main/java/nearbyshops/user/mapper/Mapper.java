package nearbyshops.user.mapper;


import nearbyshops.user.dto.DislikedShopDTO;
import nearbyshops.user.dto.PreferredShopDTO;
import nearbyshops.user.dto.ShopDTO;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;

import java.util.List;

public interface Mapper {

    public DislikedShopDTO map(DislikedShop dislikedShop);
    public PreferredShopDTO map(PreferredShop preferredShop);
    public List<PreferredShopDTO> map(List<PreferredShop> preferredShops);
    public PreferredShop map(ShopDTO shop, PreferredShop preferredShop);
    public DislikedShop map(ShopDTO shop, DislikedShop dislikedShop);
}
