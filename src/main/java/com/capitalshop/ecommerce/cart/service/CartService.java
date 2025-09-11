package com.capitalshop.ecommerce.cart.service;

import com.capitalshop.ecommerce.cart.model.dto.CartResponse;
import com.capitalshop.ecommerce.cart.model.entities.Cart;
import com.capitalshop.ecommerce.cart.model.entities.CartItem;
import com.capitalshop.ecommerce.cart.repository.CartItemRepository;
import com.capitalshop.ecommerce.cart.repository.CartRepository;
import com.capitalshop.ecommerce.user.model.entities.UserAccount;
import com.capitalshop.ecommerce.user.repository.UserAccountRepository;
import com.capitalshop.ecommerce.vendor.product.model.entities.Product;
import com.capitalshop.ecommerce.vendor.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserAccountRepository userAccountRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, UserAccountRepository userAccountRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userAccountRepository = userAccountRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public CartResponse addToCart(Long userId, Long productId, int quantity) {
        UserAccount user = userAccountRepository.findById(userId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        Cart cart = cartRepository.findByUser(user).orElseGet(() -> {
            Cart c = new Cart();
            c.setUser(user);
            return cartRepository.save(c);
        });
        // Get all items for this cart
        List<CartItem> items = cartItemRepository.findByCart(cart);
        Optional<CartItem> existingItem = items.stream().filter(i -> i.getProduct().getId().equals(productId)).findFirst();
        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            cartItemRepository.save(item);
        } else {
            CartItem item = new CartItem();
            item.setCart(cart);
            item.setProduct(product);
            item.setQuantity(quantity);
            cartItemRepository.save(item);
        }
        List<CartItem> updatedItems = cartItemRepository.findByCart(cart);
        return CartResponse.builder()
                .cartItemList(updatedItems)
                .build();
    }

    public Cart getCart(Long userId) {
        UserAccount user = userAccountRepository.findById(userId).orElseThrow();
        return cartRepository.findByUser(user).orElse(null);
    }

    @Transactional
    public void removeFromCart(Long userId, Long productId) {
        UserAccount user = userAccountRepository.findById(userId).orElseThrow();
        Cart cart = cartRepository.findByUser(user).orElseThrow();
        List<CartItem> items = cartItemRepository.findByCart(cart);
        items.stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .forEach(cartItemRepository::delete);
    }

    @Transactional
    public void clearCart(Long userId) {
        UserAccount user = userAccountRepository.findById(userId).orElseThrow();
        Cart cart = cartRepository.findByUser(user).orElseThrow();
        List<CartItem> items = cartItemRepository.findByCart(cart);
        items.forEach(cartItemRepository::delete);
    }

    public Cart updateCartItemQuantity(Long userId, Long productId, int quantity) {
        UserAccount user = userAccountRepository.findById(userId).orElseThrow();
        Cart cart = cartRepository.findByUser(user).orElseThrow();
        List<CartItem> items = cartItemRepository.findByCart(cart);
        Optional<CartItem> existingItem = items.stream().filter(i -> i.getProduct().getId().equals(productId)).findFirst();
        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(quantity);
            cartItemRepository.save(item);
        }
        return cart;
    }
}
