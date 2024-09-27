package com.scm.scm20.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {


    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name must be between 2 to 20 characters")
    private String name;


    @Email(message = "Please enter a valid email address")
    @NotBlank(message = "Email is required")
    private String email;


    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be 8 characters long")
    private String password;


    @NotBlank(message = "About is required")
    private String about;


    @NotBlank(message = "Invalid Phone Number")
    @Size(min = 10, max = 10, message = "Phone Number must be 10 digits")
    private String phoneNumber;
    
}
