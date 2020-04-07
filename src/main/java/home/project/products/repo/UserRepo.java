package home.project.products.repo;

import home.project.products.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {

    User getUserByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM User u WHERE lower(u.firstName)like %?1% or lower(u.lastName) like %?1%")
    Page<User> findByFirstNameOrLastNameLike(String name, Pageable pageable);
}
