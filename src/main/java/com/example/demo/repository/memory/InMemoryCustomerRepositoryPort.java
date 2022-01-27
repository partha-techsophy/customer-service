package com.example.demo.repository.memory;

import com.example.demo.core.domain.Customer;
import com.example.demo.execption.IErrorConstant;
import com.example.demo.execption.IllegalOperationException;
import com.example.demo.execption.ResourceNotFoundException;
import com.example.demo.repository.ICustomerRepositoryPort;
import com.example.demo.util.IdGeneratorImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ConditionalOnProperty(
        prefix = "database",
        value = "memory",
        havingValue = "true"
)
@Service
@RequiredArgsConstructor
public class InMemoryCustomerRepositoryPort implements ICustomerRepositoryPort {

    //    Dummy implementation of id generator
    private final IdGeneratorImpl idGenerator;

    @Override
    public BigInteger saveCustomer(Customer customer) {
        BigInteger id = idGenerator.nextId();
        customer.setId(id);

        try {
            return InMemoryDB.getInstance().addCustomer(id, customer);
        } catch (Exception ex) {
            throw new IllegalOperationException(IErrorConstant.INTERNAL_ERROR,
                    customer.getEmail());
        }
    }

    @Override
    public Customer find(BigInteger id) {
        Customer customer = InMemoryDB.getInstance().find(id);
        if (customer == null) {
            throw new ResourceNotFoundException(IErrorConstant.RESOURCE_NOT_FOUND, id.toString());
        }
        return customer;
    }

    @Override
    public List<Customer> findAll(int page, int size, String... sort) {
        Optional<List<Customer>> customers = InMemoryDB.getInstance().findAll(page,
                size, sort);
        if (customers.isPresent()) {
            return customers.get();
        } else {
            return Collections.EMPTY_LIST;
        }
    }


    @Override
    public void delete(BigInteger id) {
        if (InMemoryDB.getInstance().delete(id) == null) {
            throw new ResourceNotFoundException(IErrorConstant.RESOURCE_NOT_FOUND, id.toString());
        }
    }
}
