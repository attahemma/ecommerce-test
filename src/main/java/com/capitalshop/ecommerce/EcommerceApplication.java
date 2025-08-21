package com.capitalshop.ecommerce;


import com.capitalshop.ecommerce.vendor.product.model.entities.Product;
import com.capitalshop.ecommerce.vendor.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadDummyProducts(ProductRepository productRepository) {
		return args -> {
			if (productRepository.count() == 0) {
				List<Product> products = Arrays.asList(
					Product.builder()
						.productName("Wireless Mouse")
						.productImageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=400&q=80")
						.productPrice(25.99)
						.description("A high-quality wireless mouse with ergonomic design.")
						.productCode("WM-001")
						.skuNumber("SKU-1001")
						.build(),
					Product.builder()
						.productName("Bluetooth Headphones")
						.productImageUrl("https://images.unsplash.com/photo-1511367461989-f85a21fda167?auto=format&fit=crop&w=400&q=80")
						.productPrice(59.99)
						.description("Noise-cancelling over-ear Bluetooth headphones.")
						.productCode("BH-002")
						.skuNumber("SKU-1002")
						.build(),
					Product.builder()
						.productName("Mechanical Keyboard")
						.productImageUrl("https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=400&q=80")
						.productPrice(89.99)
						.description("RGB backlit mechanical keyboard for gaming and work.")
						.productCode("MK-003")
						.skuNumber("SKU-1003")
						.build(),
					Product.builder()
						.productName("4K Monitor")
						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
						.productPrice(299.99)
						.description("Ultra HD 4K monitor with vibrant colors and fast refresh rate.")
						.productCode("4K-004")
						.skuNumber("SKU-1004")
						.build(),
					Product.builder()
						.productName("USB-C Hub")
						.productImageUrl("https://images.unsplash.com/photo-1509395176047-4a66953fd231?auto=format&fit=crop&w=400&q=80")
						.productPrice(39.99)
						.description("Multi-port USB-C hub for laptops and tablets.")
						.productCode("USBC-005")
						.skuNumber("SKU-1005")
						.build()
				);
				productRepository.saveAll(products);
			}
		};
	}
}
