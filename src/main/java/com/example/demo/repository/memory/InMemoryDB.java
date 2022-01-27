package com.example.demo.repository.memory;

import com.example.demo.core.domain.Customer;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public final class InMemoryDB {

    private static Map<BigInteger, Customer> customerDB = new HashMap<>();
    private static InMemoryDB INSTANCE;

    private InMemoryDB() {
    }

    public static InMemoryDB getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryDB();
        }
        return INSTANCE;
    }

    public BigInteger addCustomer(BigInteger id, Customer customer) {
        customerDB.put(id, customer);
        return id;
    }

    public Customer find(BigInteger id) {
        return customerDB.get(id);
    }

    public Optional<List<Customer>> findAll(int page, int size, String[] sort) {
        return Optional.of(customerDB.values()
                .stream().collect(Collectors.toList()));
    }

    public Customer delete(BigInteger id) {
        return customerDB.remove(id);
    }
}
