package com.example.demo.core.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class Customer {

    BigInteger id;
    String firstName;
    String middleName;
    String lastName;
    String email;

    public boolean isValid() {
        if (this.getEmail() == null || this.getEmail().isBlank()) {
            return false;
        }
        if (this.getFirstName() == null || this.getFirstName().isBlank()) {
            return false;
        }
        if (this.getLastName() == null || this.getLastName().isBlank()) {
            return false;
        }

        return true;
    }
}
