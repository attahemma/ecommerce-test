package com.capitalshop.ecommerce.cart;

import com.capitalshop.ecommerce.cart.model.dto.AddToCartRequest;
import com.capitalshop.ecommerce.cart.model.dto.CartResponse;
import com.capitalshop.ecommerce.cart.model.entities.Cart;
import com.capitalshop.ecommerce.cart.model.entities.CartItem;
import com.capitalshop.ecommerce.cart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auth/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<CartResponse> addToCart(
           @RequestBody AddToCartRequest request
    ) {
        CartResponse cart = cartService.addToCart(
                request.getUserId(), request.getProductId(), request.getQuantity());
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
       return null;
    }

    // update cart item quantity
    @PutMapping("/update/{userId}/{productId}")
    public ResponseEntity<Cart> updateCartItemQuantity(@PathVariable Long userId, @PathVariable Long productId, @RequestParam int quantity) {
        Cart cart = cartService.updateCartItemQuantity(userId, productId, quantity);
        return ResponseEntity.ok(cart);
    }
}
