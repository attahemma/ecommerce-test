
package com.capitalshop.ecommerce.vendor.product;

import com.capitalshop.ecommerce.vendor.product.model.entities.Product;
import com.capitalshop.ecommerce.vendor.product.service.ProductService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class VendorProductController {
	private final ProductService productService;

	public VendorProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getAllProducts(
			@RequestParam(required = false) String productName,
			@RequestParam(required = false) Double minPrice,
			@RequestParam(required = false) Double maxPrice
	) {
		Specification<Product> spec = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (productName != null) {
				predicates.add(cb.like(cb.lower(root.get("productName")), "%" + productName.toLowerCase() + "%"));
			}
			if (minPrice != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("productPrice"), minPrice));
			}
			if (maxPrice != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("productPrice"), maxPrice));
			}
			return cb.and(predicates.toArray(new Predicate[0]));
		};
		return productService.findAll(spec);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.findById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		if (!productService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		product.setId(id);
		return ResponseEntity.ok(productService.save(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		if (!productService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
