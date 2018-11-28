package nearbyshops.user.mapper;


import nearbyshops.user.dto.*;
import nearbyshops.user.entity.DislikedShop;
import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.Role;
import nearbyshops.user.entity.User;

import java.util.List;

public interface Mapper {

    public DislikedShopDTO map(DislikedShop dislikedShop);
    public PreferredShopDTO map(PreferredShop preferredShop);
    public List<PreferredShopDTO> map(List<PreferredShop> preferredShops);
    public PreferredShop map(ShopDTO shop, PreferredShop preferredShop);
    public DislikedShop map(ShopDTO shop, DislikedShop dislikedShop);
    public User map(UserDetailsModel userDetailsModel);
    public RoleDTO map(Role role);
    public List<RoleDTO> map(List<Role> roles,List<RoleDTO> rolesDTO);
    public Role map(RoleDTO roleDTO);
}
