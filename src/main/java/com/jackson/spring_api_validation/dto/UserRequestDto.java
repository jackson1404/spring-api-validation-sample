package com.jackson.spring_api_validation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    private String userName;

    @NotBlank(message = "Email is required.")
    @Email(message = "Email must be a valid email address.")
    private String userEmail;

    @Min(value = 18, message = "User must be at least 18 years old.")
    @Max(value = 100, message = "User age cannot be more than 100.")
    private int userAge;

    @NotNull(message = "Date of birth is required.")
    @Past(message = "Date of birth must be in the past.")
    private LocalDate dob;

    @NotBlank(message = "Password is required.")
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$",
            message = "Password must be at least 8 characters long and include uppercase, lowercase, number, and special character."
    )
    private String userPassword;

    @NotBlank(message = "Address is required.")
    @Size(max = 255, message = "Address must not exceed 255 characters.")
    private String userAddress;
}
