package com.example.demo.core.services.impl;

import com.example.demo.core.domain.Customer;
import com.example.demo.execption.InvalidInputException;
import com.example.demo.repository.ICustomerRepositoryPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    private static final BigInteger ID = BigInteger.ONE;
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String EMAIL = "email@demo.com";
    private static final int PAGE = 1;
    private static final int SIZE = 1;
    private static final String SORT = "firstName asc";

    @Mock
    ICustomerRepositoryPort repositoryPort;

    @InjectMocks
    CustomerService customerService;

    @Test
    @DisplayName("Test assert save customer")
    void saveCustomer() {
        Customer givenCustomer = givenCustomer();

        when(repositoryPort.saveCustomer(any(Customer.class))).thenReturn(ID);
        BigInteger customerId = customerService.saveCustomer(givenCustomer);

        verify(repositoryPort, times(1)).saveCustomer(any(Customer.class));

        assertEquals(ID, customerId);

    }

    @Test
    @DisplayName("Test assert invalid customer email")
    void shouldThrowExceptionOnSave() {
        Customer givenCustomer = givenCustomer();
        givenCustomer.setEmail(null);

        InvalidInputException exception =
                assertThrows(InvalidInputException.class,
                        () -> {
                            customerService.saveCustomer(givenCustomer);
                        });
    }

    @Test
    @DisplayName("Test assert find customer by ID")
    void findById() {
        Customer givenCustomer = givenCustomer();

        when(repositoryPort.find(ID)).thenReturn(givenCustomer);
        Customer customer = customerService.findById(ID);

        verify(repositoryPort, times(1)).find(ID);

        assertEquals(givenCustomer.getId(), customer.getId());
        assertEquals(givenCustomer.getEmail(), customer.getEmail());
        assertEquals(givenCustomer.getFirstName(), customer.getFirstName());
        assertEquals(givenCustomer.getMiddleName(), customer.getMiddleName());
        assertEquals(givenCustomer.getLastName(), customer.getLastName());

    }

    @Test
    @DisplayName("Test assert find all customers")
    void findAll() {

        List<Customer> givenCustomers = givenCustomerList();

        when(customerService.findAll(PAGE, SIZE, SORT)).thenReturn(givenCustomers);
        List<Customer> customers = customerService.findAll(PAGE, SIZE, SORT);

        verify(repositoryPort, times(1)).findAll(PAGE, SIZE, SORT);

        assertEquals(givenCustomers.size(), customers.size());
        assertEquals(givenCustomers.get(0).getId(), customers.get(0).getId());
    }

    @Test
    @DisplayName("Test assert delete customer by ID")
    void delete() {
    }

    private List<Customer> givenCustomerList() {
        return List.of(
                givenCustomer()
        );
    }

    private Customer givenCustomer() {
        return Customer.builder()
                .id(ID)
                .email(EMAIL)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .build();
    }
}