package com.example.demo.core.services.impl;

import com.example.demo.core.domain.Customer;
import com.example.demo.core.services.ICustomerService;
import com.example.demo.execption.IErrorConstant;
import com.example.demo.execption.InvalidInputException;
import com.example.demo.repository.ICustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final ICustomerRepositoryPort repositoryPort;

    @Override
    public BigInteger saveCustomer(Customer customer) {
        //validate data
        if (!customer.isValid()) {
            throw new InvalidInputException(IErrorConstant.INVALID_INPUT,
                    customer.getEmail());
        }
        BigInteger id = repositoryPort.saveCustomer(customer);
        return id;
    }

    @Override
    public Customer findById(BigInteger id) {
        return repositoryPort.find(id);
    }

    @Override
    public List<Customer> findAll(int page, int size, String... sort) {
        return repositoryPort.findAll(page, size, sort);
    }

    @Override
    public void delete(BigInteger id) {
        repositoryPort.delete(id);
    }

}
