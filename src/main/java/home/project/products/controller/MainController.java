package home.project.products.controller;

import home.project.products.entities.Product;
import home.project.products.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class.getName());

    private final ProductRepository productRepository;

    public MainController(ProductRepository productRepository) {
        logger.error("MainController()");
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProduct(Product product) {

        logger.error("Method getProduct()");
        logger.error(String.valueOf(product));

        return productRepository.findAll();
    }

    @GetMapping("/create")
    public void create() {

        productRepository.save(new Product(2L, "Vit'ka"));
    }
}
