package com.example.demo.application.rest.request;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
@Builder
public class CustomerRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 3, message = "First name must be minimum three characters")
    String firstName;
    String middleName;
    @NotBlank(message = "Last name is required")
    @Size(min = 3, message = "Last name must be minimum three characters")
    String lastName;
    @Email(message = "Please provide a valid email")
    String email;
}
