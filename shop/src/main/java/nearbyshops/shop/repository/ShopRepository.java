package nearbyshops.shop.repository;

import nearbyshops.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ShopRepository extends JpaRepository<Shop,Long> {

}
