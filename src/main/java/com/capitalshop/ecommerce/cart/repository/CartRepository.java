package com.capitalshop.ecommerce.cart.repository;

import com.capitalshop.ecommerce.cart.model.entities.Cart;
import com.capitalshop.ecommerce.user.model.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(UserAccount user);
}
