package com.anuj.bfsi_backend.controller;


import com.anuj.bfsi_backend.model.Customer;
import com.anuj.bfsi_backend.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service=service;
    }

    @PostMapping
    public Customer create(@Valid @RequestBody Customer customer){
        return service.create(customer);
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id,@Valid @RequestBody Customer customer){
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
