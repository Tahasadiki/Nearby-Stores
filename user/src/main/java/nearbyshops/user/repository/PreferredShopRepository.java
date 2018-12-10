package nearbyshops.user.repository;

import nearbyshops.user.entity.PreferredShop;
import nearbyshops.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PreferredShopRepository extends JpaRepository<PreferredShop,Long> {

    PreferredShop findPreferredShopById(long id);

    List<PreferredShop> findPreferredShopsByUser(User user);

}
