package com.capitalshop.ecommerce.vendor.product;

import com.capitalshop.ecommerce.vendor.product.model.entities.Product;
import com.capitalshop.ecommerce.vendor.product.service.ProductService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth/products")
public class VendorProductController {
	private final ProductService productService;

	public VendorProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public Page<Product> getAllProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(required = false) String productName,
			@RequestParam(required = false) String searchTerm,
			@RequestParam(required = false) Double minPrice,
			@RequestParam(required = false) Double maxPrice
	) {
		Specification<Product> spec = (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();
			if (productName != null && !productName.isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("productName")), "%" + productName.toLowerCase() + "%"));
			}
			if (searchTerm != null && !searchTerm.isEmpty()) {
				predicates.add(cb.like(cb.lower(root.get("productName")), "%" + searchTerm.toLowerCase() + "%"));
			}
			if (minPrice != null) {
				predicates.add(cb.greaterThanOrEqualTo(root.get("productPrice"), minPrice));
			}
			if (maxPrice != null) {
				predicates.add(cb.lessThanOrEqualTo(root.get("productPrice"), maxPrice));
			}
			return cb.and(predicates.toArray(new Predicate[0]));
		};
		Pageable pageable = PageRequest.of(page, size);
		return productService.findAll(spec, pageable);
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
