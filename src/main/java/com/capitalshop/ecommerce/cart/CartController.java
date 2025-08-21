package com.capitalshop.ecommerce.cart;

import com.capitalshop.ecommerce.cart.model.entities.Cart;
import com.capitalshop.ecommerce.cart.model.entities.CartItem;
import com.capitalshop.ecommerce.cart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{userId}/{productId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long userId, @PathVariable Long productId, @RequestParam(defaultValue = "1") int quantity) {
        Cart cart = cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        Cart cart = cartService.getCart(userId);
        if (cart == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/remove/{userId}/{productId}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.removeFromCart(userId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/items/{userId}")
    public ResponseEntity<List<CartItem>> getAllCartItems(@PathVariable Long userId) {
        Cart cart = cartService.getCart(userId);
        if (cart == null || cart.getItems() == null) {
            return ResponseEntity.ok(List.of());
        }
        return ResponseEntity.ok(cart.getItems());
    }
}
