package home.project.products.controller;

import home.project.products.entities.User;
import home.project.products.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        logger.warn("UserController()");
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<User> findAll() {

        logger.warn("Method findAll()");
        return userRepo.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        logger.warn("Method findById() in UserController");
        return userRepo.findById(id).get();
    }

    @PostMapping
    public User save(@Valid @RequestBody User user) {

        logger.warn("Method save() in UserController");
        logger.warn("save user: " + user);

        return userRepo.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {

        logger.warn("Method update() in UserController");

        user.setId(id);
        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        logger.warn("Method delete() in UserController");
        userRepo.deleteById(id);
    }

    @GetMapping("/profile")
    public User getProfile(@Valid @RequestParam String email, @Valid @RequestParam String password) {

        logger.warn("Method getProfile() in User");
        return userRepo.getUserByEmailAndPassword(email, password);
    }

    @GetMapping("/search")
    public List<User> getUsersByName(@Valid @RequestParam String name) {

        logger.warn("Method getUsersByName() in UserController, " + name);
        return userRepo.findByFirstNameOrLastNameLike(name.toLowerCase());
    }
}
