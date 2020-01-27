package home.project.products.controller;

import home.project.products.entities.Product;
import home.project.products.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/products")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class.getName());

    private final ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        logger.warn("MainController()");
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> findAll(Product product) {

        logger.warn("Method findAll()");
        logger.warn(String.valueOf(product));

        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {

        logger.warn("Method findById()" + "\nID: " + id);
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {

        logger.warn("Method create()");
        logger.warn("save product: " + product);

        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {

        logger.warn("Method update()");

        product.setId(id);
        return productRepository.save(product);
    }
}
