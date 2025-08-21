package com.capitalshop.ecommerce.cart.repository;

import com.capitalshop.ecommerce.cart.model.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
