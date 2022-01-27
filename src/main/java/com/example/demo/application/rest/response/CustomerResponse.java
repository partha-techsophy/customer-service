package com.example.demo.application.rest.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerResponse {
    String id;
    String firstName;
    String middleName;
    String lastName;
    String email;
}
