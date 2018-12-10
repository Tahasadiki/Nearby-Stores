package nearbyshops.shop.mapper;


import nearbyshops.shop.dto.ShopDTO;
import nearbyshops.shop.dto.tomTom.ShopListDTO;


import java.util.List;

public interface Mapper {

    public List<ShopDTO> map(ShopListDTO shopListDTO);
}
