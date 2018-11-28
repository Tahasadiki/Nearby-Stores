package nearbyshops.user.repository;


import nearbyshops.user.dto.UserDetailsModel;
import nearbyshops.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(long id);
    User findUserByEmail(String email);

}
