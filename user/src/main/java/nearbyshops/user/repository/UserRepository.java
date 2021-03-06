package nearbyshops.user.repository;


import nearbyshops.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(long id);
    User findUserByEmail(String email);

}
