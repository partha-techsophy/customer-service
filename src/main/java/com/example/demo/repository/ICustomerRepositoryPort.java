package com.example.demo.repository;

import com.example.demo.core.domain.Customer;

import java.math.BigInteger;
import java.util.List;

public interface ICustomerRepositoryPort {

    BigInteger saveCustomer(Customer customer);

    Customer find(BigInteger id);

    List<Customer> findAll(int page, int size, String... sort);

    void delete(BigInteger id);
}
