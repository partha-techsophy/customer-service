package com.example.demo.application.rest.adapter.impl;

import com.example.demo.application.rest.adapter.ICustomerRestServicePort;
import com.example.demo.application.rest.request.CustomerRequest;
import com.example.demo.application.rest.response.CustomerResponse;
import com.example.demo.application.rest.response.PageInfo;
import com.example.demo.application.rest.response.PageResponse;
import com.example.demo.core.domain.Customer;
import com.example.demo.core.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerRestServicePort implements ICustomerRestServicePort {

    private final ICustomerService customerService;

    @Override
    public BigInteger addCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .email(customerRequest.getEmail())
                .firstName(customerRequest.getFirstName())
                .middleName(customerRequest.getMiddleName())
                .lastName(customerRequest.getLastName())
                .build();

        return customerService.saveCustomer(customer);
    }

    @Override
    public CustomerResponse find(BigInteger id) {
        Customer customer = customerService.findById(id);
        return CustomerResponse.builder()
                .id(customer.getId().toString())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

    @Override
    public PageResponse<CustomerResponse> findAll(int page, int size, String[] sort) {
        List<Customer> customers = customerService.findAll(page, size, sort);

        return PageResponse.<CustomerResponse>builder()
                .content(customers.stream()
                        .map(Customer.class::cast)
                        .map(this::toCustomerResponse)
                        .collect(Collectors.toList()))
                .pageInfo(PageInfo.builder()
                        .currentPage(0)
                        .totalCount(1)
                        .totalPages(1)
                        .build())
                .build();

    }

    @Override
    public void delete(BigInteger id) {
        customerService.delete(id);
    }

    private CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId().toString())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
