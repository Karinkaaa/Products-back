package home.project.products.controller;

import home.project.products.entities.User;
import home.project.products.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class.getName());

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

        logger.warn("Method findById() in User");
        return userRepo.findById(id).get();
    }

    @PostMapping
    public User save(@RequestBody User user) {

        logger.warn("Method save() in User");
        logger.warn("save user: " + user);

        return userRepo.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {

        logger.warn("Method update() in User");

        user.setId(id);
        return userRepo.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        logger.warn("Method delete() in User");
        userRepo.deleteById(id);
    }
}
