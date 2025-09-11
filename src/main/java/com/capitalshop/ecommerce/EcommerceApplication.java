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
			if (productRepository.count() == 5) {
				List<Product> products = Arrays.asList(
//					Product.builder()
//						.productName("Wireless Mouse")
//						.productImageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=400&q=80")
//						.productPrice(25.99)
//						.description("A high-quality wireless mouse with ergonomic design.")
//						.productCode("WM-001")
//						.skuNumber("SKU-1001")
//						.build(),
//					Product.builder()
//						.productName("Bluetooth Headphones")
//						.productImageUrl("https://images.unsplash.com/photo-1511367461989-f85a21fda167?auto=format&fit=crop&w=400&q=80")
//						.productPrice(59.99)
//						.description("Noise-cancelling over-ear Bluetooth headphones.")
//						.productCode("BH-002")
//						.skuNumber("SKU-1002")
//						.build(),
//					Product.builder()
//						.productName("Mechanical Keyboard")
//						.productImageUrl("https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=400&q=80")
//						.productPrice(89.99)
//						.description("RGB backlit mechanical keyboard for gaming and work.")
//						.productCode("MK-003")
//						.skuNumber("SKU-1003")
//						.build(),
//					Product.builder()
//						.productName("4K Monitor")
//						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
//						.productPrice(299.99)
//						.description("Ultra HD 4K monitor with vibrant colors and fast refresh rate.")
//						.productCode("4K-004")
//						.skuNumber("SKU-1004")
//						.build(),
//					Product.builder()
//						.productName("USB-C Hub")
//						.productImageUrl("https://images.unsplash.com/photo-1509395176047-4a66953fd231?auto=format&fit=crop&w=400&q=80")
//						.productPrice(39.99)
//						.description("Multi-port USB-C hub for laptops and tablets.")
//						.productCode("USBC-005")
//						.skuNumber("SKU-1005")
//						.build(),
					Product.builder()
						.productName("Smartphone Stand")
						.productImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=400&q=80")
						.productPrice(12.99)
						.description("Adjustable smartphone stand for desk use.")
						.productCode("SS-006")
						.skuNumber("SKU-1006")
						.build(),
					Product.builder()
						.productName("Portable SSD")
						.productImageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=400&q=80")
						.productPrice(109.99)
						.description("1TB high-speed portable SSD.")
						.productCode("PSSD-007")
						.skuNumber("SKU-1007")
						.build(),
					Product.builder()
						.productName("Laptop Sleeve")
						.productImageUrl("https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=400&q=80")
						.productPrice(19.99)
						.description("Protective laptop sleeve for 13-inch laptops.")
						.productCode("LS-008")
						.skuNumber("SKU-1008")
						.build(),
					Product.builder()
						.productName("Wireless Charger")
						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
						.productPrice(29.99)
						.description("Fast wireless charger for smartphones.")
						.productCode("WC-009")
						.skuNumber("SKU-1009")
						.build(),
					Product.builder()
						.productName("Noise Cancelling Earbuds")
						.productImageUrl("https://images.unsplash.com/photo-1511367461989-f85a21fda167?auto=format&fit=crop&w=400&q=80")
						.productPrice(79.99)
						.description("True wireless noise cancelling earbuds.")
						.productCode("NCE-010")
						.skuNumber("SKU-1010")
						.build(),
					Product.builder()
						.productName("Smartwatch")
						.productImageUrl("https://images.unsplash.com/photo-1516574187841-cb9cc2ca948b?auto=format&fit=crop&w=400&q=80")
						.productPrice(199.99)
						.description("Fitness tracking smartwatch with heart rate monitor.")
						.productCode("SW-011")
						.skuNumber("SKU-1011")
						.build(),
					Product.builder()
						.productName("Bluetooth Speaker")
						.productImageUrl("https://images.unsplash.com/photo-1465101178521-c1a9136a3b99?auto=format&fit=crop&w=400&q=80")
						.productPrice(49.99)
						.description("Portable Bluetooth speaker with deep bass.")
						.productCode("BS-012")
						.skuNumber("SKU-1012")
						.build(),
					Product.builder()
						.productName("Webcam 1080p")
						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
						.productPrice(69.99)
						.description("Full HD 1080p webcam for video calls.")
						.productCode("WCAM-013")
						.skuNumber("SKU-1013")
						.build(),
					Product.builder()
						.productName("Ergonomic Office Chair")
						.productImageUrl("https://images.unsplash.com/photo-1515378791036-0648a3ef77b2?auto=format&fit=crop&w=400&q=80")
						.productPrice(249.99)
						.description("Adjustable ergonomic office chair for comfort.")
						.productCode("EOC-014")
						.skuNumber("SKU-1014")
						.build(),
					Product.builder()
						.productName("Desk Lamp")
						.productImageUrl("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80")
						.productPrice(34.99)
						.description("LED desk lamp with adjustable brightness.")
						.productCode("DL-015")
						.skuNumber("SKU-1015")
						.build(),
					Product.builder()
						.productName("Gaming Mouse Pad")
						.productImageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=400&q=80")
						.productPrice(14.99)
						.description("Large gaming mouse pad with non-slip base.")
						.productCode("GMP-016")
						.skuNumber("SKU-1016")
						.build(),
					Product.builder()
						.productName("USB Flash Drive 128GB")
						.productImageUrl("https://images.unsplash.com/photo-1465101178521-c1a9136a3b99?auto=format&fit=crop&w=400&q=80")
						.productPrice(24.99)
						.description("128GB USB 3.0 flash drive for fast data transfer.")
						.productCode("UFD-017")
						.skuNumber("SKU-1017")
						.build(),
					Product.builder()
						.productName("Laptop Cooling Pad")
						.productImageUrl("https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=400&q=80")
						.productPrice(27.99)
						.description("Cooling pad with dual fans for laptops.")
						.productCode("LCP-018")
						.skuNumber("SKU-1018")
						.build(),
					Product.builder()
						.productName("Wireless Presenter")
						.productImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=400&q=80")
						.productPrice(19.99)
						.description("Wireless presenter with laser pointer.")
						.productCode("WP-019")
						.skuNumber("SKU-1019")
						.build(),
					Product.builder()
						.productName("Action Camera")
						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
						.productPrice(129.99)
						.description("Waterproof 4K action camera for outdoor adventures.")
						.productCode("AC-020")
						.skuNumber("SKU-1020")
						.build(),
					Product.builder()
						.productName("Fitness Tracker")
						.productImageUrl("https://images.unsplash.com/photo-1516574187841-cb9cc2ca948b?auto=format&fit=crop&w=400&q=80")
						.productPrice(49.99)
						.description("Fitness tracker with heart rate and sleep monitoring.")
						.productCode("FT-021")
						.skuNumber("SKU-1021")
						.build(),
					Product.builder()
						.productName("Tablet Stand")
						.productImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=400&q=80")
						.productPrice(15.99)
						.description("Adjustable stand for tablets and e-readers.")
						.productCode("TS-022")
						.skuNumber("SKU-1022")
						.build(),
					Product.builder()
						.productName("Smart Light Bulb")
						.productImageUrl("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80")
						.productPrice(22.99)
						.description("WiFi-enabled smart LED light bulb.")
						.productCode("SLB-023")
						.skuNumber("SKU-1023")
						.build(),
					Product.builder()
						.productName("Bluetooth Tracker")
						.productImageUrl("https://images.unsplash.com/photo-1465101178521-c1a9136a3b99?auto=format&fit=crop&w=400&q=80")
						.productPrice(18.99)
						.description("Bluetooth tracker for keys and bags.")
						.productCode("BT-024")
						.skuNumber("SKU-1024")
						.build(),
					Product.builder()
						.productName("Wireless Earphones")
						.productImageUrl("https://images.unsplash.com/photo-1511367461989-f85a21fda167?auto=format&fit=crop&w=400&q=80")
						.productPrice(54.99)
						.description("Wireless earphones with charging case.")
						.productCode("WE-025")
						.skuNumber("SKU-1025")
						.build(),
					Product.builder()
						.productName("Smart Plug")
						.productImageUrl("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80")
						.productPrice(16.99)
						.description("WiFi smart plug for home automation.")
						.productCode("SP-026")
						.skuNumber("SKU-1026")
						.build(),
					Product.builder()
						.productName("USB Wall Charger")
						.productImageUrl("https://images.unsplash.com/photo-1465101046530-73398c7f28ca?auto=format&fit=crop&w=400&q=80")
						.productPrice(13.99)
						.description("4-port USB wall charger for multiple devices.")
						.productCode("UWC-027")
						.skuNumber("SKU-1027")
						.build(),
					Product.builder()
						.productName("Laptop Stand")
						.productImageUrl("https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?auto=format&fit=crop&w=400&q=80")
						.productPrice(23.99)
						.description("Aluminum laptop stand for better ergonomics.")
						.productCode("LS-028")
						.skuNumber("SKU-1028")
						.build(),
					Product.builder()
						.productName("Wireless Gaming Controller")
						.productImageUrl("https://images.unsplash.com/photo-1517336714731-489689fd1ca8?auto=format&fit=crop&w=400&q=80")
						.productPrice(64.99)
						.description("Wireless controller for PC and console gaming.")
						.productCode("WGC-029")
						.skuNumber("SKU-1029")
						.build(),
					Product.builder()
						.productName("Portable Projector")
						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
						.productPrice(219.99)
						.description("Mini portable projector for home entertainment.")
						.productCode("PP-030")
						.skuNumber("SKU-1030")
						.build(),
					Product.builder()
						.productName("Smart Thermostat")
						.productImageUrl("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80")
						.productPrice(139.99)
						.description("WiFi smart thermostat for home climate control.")
						.productCode("ST-031")
						.skuNumber("SKU-1031")
						.build(),
					Product.builder()
						.productName("Wireless Security Camera")
						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
						.productPrice(89.99)
						.description("Wireless security camera with night vision.")
						.productCode("WSC-032")
						.skuNumber("SKU-1032")
						.build(),
					Product.builder()
						.productName("Bluetooth Car Adapter")
						.productImageUrl("https://images.unsplash.com/photo-1465101178521-c1a9136a3b99?auto=format&fit=crop&w=400&q=80")
						.productPrice(21.99)
						.description("Bluetooth adapter for car audio systems.")
						.productCode("BCA-033")
						.skuNumber("SKU-1033")
						.build(),
					Product.builder()
						.productName("Wireless Charging Pad")
						.productImageUrl("https://images.unsplash.com/photo-1519125323398-675f0ddb6308?auto=format&fit=crop&w=400&q=80")
						.productPrice(24.99)
						.description("Slim wireless charging pad for smartphones.")
						.productCode("WCP-034")
						.skuNumber("SKU-1034")
						.build(),
					Product.builder()
						.productName("Smart Door Lock")
						.productImageUrl("https://images.unsplash.com/photo-1506744038136-46273834b3fb?auto=format&fit=crop&w=400&q=80")
						.productPrice(179.99)
						.description("Keyless smart door lock with app control.")
						.productCode("SDL-035")
						.skuNumber("SKU-1035")
						.build()
				);
				productRepository.saveAll(products);
			}
		};
	}
}
