package pt.dockoder.secureserver.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.dockoder.secureserver.domain.users.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM User u where u.userName = ?1 and u.password = ?2 ")
    Optional login(String username, String password);
    Optional findByToken(String token);
}
