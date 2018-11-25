package nearbyshops.user.repository;

import nearbyshops.user.entity.PreferredShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PreferredShopRepository extends JpaRepository<PreferredShop,Long> {

    PreferredShop findPreferredShopById(long id);
}
