package pl.coderslab.charity.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByName(String userName);

    Optional<User> findUserByEmail(String email);

    @Query(value = "select * from user join user_role ur on user.id = ur.user_id where role_id =1", nativeQuery = true)
    List<User>getUsers();

    @Query(value = "select * from user join user_role ur on user.id = ur.user_id where role_id =2", nativeQuery = true)
    List<User>getAdmins();

    Optional<User> findUserById(Long id);


}
