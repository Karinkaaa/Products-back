package home.project.products.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private Long id;

    private String name;
    private Double price;
    private String image;

    public Product() {
    }

    public Product(Long id, String name, Double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("\nPRODUCT:\n");
        sb.append("Id: ").append(this.id);
        sb.append("\nName: ").append(this.name);
        sb.append("\nPrice: ").append(this.price);
        sb.append("\nImage: ").append(this.image).append("\n");

        return sb.toString();
    }
}
