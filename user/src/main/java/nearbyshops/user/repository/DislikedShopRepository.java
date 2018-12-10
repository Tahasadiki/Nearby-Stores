package nearbyshops.user.repository;

import nearbyshops.user.entity.DislikedShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DislikedShopRepository extends JpaRepository<DislikedShop,Long> {

}
