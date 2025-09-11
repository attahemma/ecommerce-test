package com.capitalshop.ecommerce.cart.model.dto;

import com.capitalshop.ecommerce.cart.model.entities.Cart;
import com.capitalshop.ecommerce.cart.model.entities.CartItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private List<CartItem> cartItemList;
}
