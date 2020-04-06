package home.project.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {

	public static final String PATTERN_BASE_64 = "^data:image\\/jpeg;base64,(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{4})$";
	public static final String PATTERN_URL = "(?:http(s)?://)?[\\w.-]+(?:\\.[\\w-]+)+[\\w\\-_~:/?#@!&',;=.]+$";
	public static final String IMAGE_PATTERN = "(" + PATTERN_BASE_64 + "|" + PATTERN_URL + ")";
	public static final String PHONE_PATTERN = "^\\+380\\d{3}\\d{2}\\d{2}\\d{2}$";

	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
	}
}
