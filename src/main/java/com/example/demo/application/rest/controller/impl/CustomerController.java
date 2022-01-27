package com.example.demo.application.rest.controller.impl;

import com.example.demo.application.rest.adapter.ICustomerRestServicePort;
import com.example.demo.application.rest.controller.ICustomerController;
import com.example.demo.application.rest.request.CustomerRequest;
import com.example.demo.application.rest.response.CreateResponse;
import com.example.demo.application.rest.response.CustomerResponse;
import com.example.demo.application.rest.response.PageResponse;
import com.example.demo.application.rest.response.ResponseObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;


@RestController
@RequiredArgsConstructor
public class CustomerController implements ICustomerController {

    private final ICustomerRestServicePort servicePort;

    @Override
    public ResponseObject<?> createCustomer(CustomerRequest customerRequest) {

        CreateResponse retVal = CreateResponse.builder()
                .id(String.valueOf(servicePort.addCustomer(customerRequest)))
                .build();

        return ResponseObject.builder().data(retVal)
                .message(ResponseObject.SUCCESS).build();
    }

    @Override
    public ResponseObject<CustomerResponse> getCustomer(String id) {
        return ResponseObject.<CustomerResponse>builder()
                .data(servicePort.find(new BigInteger(id)))
                .message(ResponseObject.SUCCESS)
                .build();
    }

    @Override
    public ResponseObject<PageResponse<CustomerResponse>> getAllCustomers(int page, int size, String[] sort) {
        return ResponseObject.<PageResponse<CustomerResponse>>builder()
                .data(servicePort.findAll(page, size, sort))
                .message(ResponseObject.SUCCESS)
                .build();
    }

    @Override
    public ResponseEntity<?> deleteCustomer(String id) {
        servicePort.delete(new BigInteger(id));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
