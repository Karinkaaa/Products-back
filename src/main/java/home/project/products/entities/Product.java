package home.project.products.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

    @Id
    private int id;
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer("\nPRODUCT:\n");
        sb.append("Id: ").append(this.id);
        sb.append("\nName: ").append(this.name).append("\n");

        return sb.toString();
    }
}
