package home.project.products.controller;

import home.project.products.entities.User;
import home.project.products.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
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

    @PostMapping
    public User save(@RequestBody User user) {

        logger.warn("Method save()");
        return userRepo.save(user);
    }
}
