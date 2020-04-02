package home.project.products.controller;

import home.project.products.entities.Product;
import home.project.products.repo.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private final ProductRepo productRepo;

    public ProductController(ProductRepo productRepo) {
        logger.warn("ProductController()");
        this.productRepo = productRepo;
    }

    @GetMapping
    public List<Product> findAll() {

        logger.warn("Method findAll() in ProductController");

        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {

        logger.warn("Method findById()" + " in ProductController\nID: " + id);
        return productRepo.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {

        logger.warn("Method save() in ProductController");
        logger.warn("save product: " + product);

        return productRepo.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {

        logger.warn("Method update() in ProductController");

        product.setId(id);
        return productRepo.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        logger.warn("Method delete() in ProductController");
        productRepo.deleteById(id);
    }

    @GetMapping("/search")
    public List<Product> getProductsByName(@RequestParam String name) {

        logger.warn("Method getProductsByName() in ProductController, " + name);
        return productRepo.findByNameContainingIgnoreCase(name);
    }
}
