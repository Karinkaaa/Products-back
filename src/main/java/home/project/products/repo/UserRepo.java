package home.project.products.repo;

import home.project.products.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    User getUserByEmailAndPassword(String email, String password);

//    @Query("{$or:[{firstName:{$regex:?0,$options:'i'}},{lastName:{$regex:?0,$options:'i'}}]}")
    List<User> findByFirstNameLike(String name);
}
