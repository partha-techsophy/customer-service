package com.example.demo.application.rest.controller;

import com.example.demo.application.rest.request.CustomerRequest;
import com.example.demo.application.rest.response.CustomerResponse;
import com.example.demo.application.rest.response.PageResponse;
import com.example.demo.application.rest.response.ResponseObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/customers")
public interface ICustomerController {

    @PostMapping(value = "/", produces =
            MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseObject<?> createCustomer(@RequestBody CustomerRequest customerRequest);

    @GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseObject<CustomerResponse> getCustomer(@PathVariable("id") String id);

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseObject<PageResponse<CustomerResponse>> getAllCustomers(
            @RequestParam("page") int page, @RequestParam("size") int size,
            @RequestParam("sort") String[] sort);

    @DeleteMapping(value = "/customer/{id}")
    ResponseEntity<?> deleteCustomer(@PathVariable("id") String id);
}
