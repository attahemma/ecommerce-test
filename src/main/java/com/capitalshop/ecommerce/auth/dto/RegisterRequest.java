package com.capitalshop.ecommerce.auth.dto;

import com.capitalshop.ecommerce.user.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private UserType userType; // Assuming UserType is an enum defined in your project

    // Getters and Setters
}