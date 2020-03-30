package home.project.products.controller;

import home.project.products.entities.Product;
import home.project.products.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        logger.warn("ProductController()");
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> findAll(Product product) {

        logger.warn("Method findAll() in ProductController");
        logger.warn(String.valueOf(product));

        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {

        logger.warn("Method findById()" + " in ProductController\nID: " + id);
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {

        logger.warn("Method save() in ProductController");
        logger.warn("save product: " + product);

        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {

        logger.warn("Method update() in ProductController");

        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        logger.warn("Method delete() in ProductController");
        productRepository.deleteById(id);
    }
}
