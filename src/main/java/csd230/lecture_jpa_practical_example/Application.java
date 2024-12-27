package csd230.lecture_jpa_practical_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private final ProductRepository productRepository;

	public Application(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product newProduct = new Product("Laptop", "High performance laptop", 1200.00);
		Product newProduct2 = new Product("Laptop", "Low performance laptop", 1000.00);
		productRepository.save(newProduct);
		productRepository.save(newProduct2);

		List<Product> allProducts = productRepository.findAll();

		Optional<Product> productOptional = productRepository.findById(1L);
		if(productOptional.isPresent()){
			Product product = productOptional.get();
			// Do something with the product.
			System.out.println(product);
		}

		productOptional = Optional.ofNullable(productRepository.findFirstByName("Laptop"));
		if(productOptional.isPresent()){
			Product product = productOptional.get();
			// Do something with the product.
			System.out.println(product);
		}

		List<Product> laptops = productRepository.findAllByName("Laptop");
		laptops.forEach(System.out::println);

		Product newProduct3 = new Product("ssd", "100GB drive", 200.00);
		productRepository.save(newProduct3);

		laptops = productRepository.findAll();
		laptops.forEach(System.out::println);


	}
}
