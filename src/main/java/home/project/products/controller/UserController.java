package home.project.products.controller;

import home.project.products.entities.User;
import home.project.products.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Page<User> findAll(
            @RequestParam String filteredName,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {

        logger.warn("FilteredName: " + filteredName);
        logger.warn("Method findAll() " + pageable);

        if (filteredName.length() > 0) {
            return userRepo.findByFirstNameOrLastNameLike(filteredName.toLowerCase(), pageable);
        }
        return userRepo.findAll(pageable);
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
}
