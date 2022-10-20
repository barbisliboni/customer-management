package com.customers.customer.controller;

import com.customers.customer.model.Customer;
import com.customers.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerRepository.save(customer));
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.OK).body(customerRepository.save(customer));
    }

    @GetMapping("/listOfCustomers")
    public ResponseEntity <List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}