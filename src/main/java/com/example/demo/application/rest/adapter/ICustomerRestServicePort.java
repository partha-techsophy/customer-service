package com.example.demo.application.rest.adapter;

import com.example.demo.application.rest.request.CustomerRequest;
import com.example.demo.application.rest.response.CustomerResponse;
import com.example.demo.application.rest.response.PageResponse;

import java.math.BigInteger;

public interface ICustomerRestServicePort {

    BigInteger addCustomer(CustomerRequest customerRequest);

    CustomerResponse find(BigInteger id);

    PageResponse<CustomerResponse> findAll(int page, int size, String[] sort);

    void delete(BigInteger id);
}
