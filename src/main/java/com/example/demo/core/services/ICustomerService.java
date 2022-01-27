package com.example.demo.core.services;

import com.example.demo.core.domain.Customer;

import java.math.BigInteger;
import java.util.List;

public interface ICustomerService {

    BigInteger saveCustomer(Customer customer);

    Customer findById(BigInteger id);

    List<Customer> findAll(int page, int size, String... sort);

    void delete(BigInteger id);

}


