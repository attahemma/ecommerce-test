package com.capitalshop.ecommerce.cart.model.entities;

import com.capitalshop.ecommerce.user.model.entities.UserAccount;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserAccount user;
}
