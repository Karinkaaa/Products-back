package home.project.products.controller;

import home.project.products.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class.getName());

    public MainController() {
        logger.error("MainController()");
    }

    @GetMapping
    public Product getProduct(Product product) {

        logger.error("Method getProduct()");
        logger.error(String.valueOf(product));
        return new Product("brot");
    }
}
