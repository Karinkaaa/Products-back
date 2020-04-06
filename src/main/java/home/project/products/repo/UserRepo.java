package home.project.products.repo;

import home.project.products.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User getUserByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM User u WHERE lower(u.firstName)like %?1% or lower(u.lastName) like %?1%")
    List<User> findByFirstNameOrLastNameLike(String name);
}
