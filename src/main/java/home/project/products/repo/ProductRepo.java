package home.project.products.repo;

import home.project.products.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
}