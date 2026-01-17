package com.anuj.bfsi_backend.service;

import com.anuj.bfsi_backend.exceptions.CustomerNotFoundException;
import com.anuj.bfsi_backend.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    private final Map<Long, Customer> store = new HashMap<>();
    private Long idCounter = 1L;

    public Customer create(Customer customer){
        customer.setId(idCounter++);
        store.put(customer.getId(),customer);
        return customer;
    }

    public Customer getById(Long id){
        return store.get(id);
    }

    public List<Customer> getAll(){
        return new ArrayList<>(store.values());
    }

    public Customer update(Long id, Customer updated){
        Customer existingCustomer = store.get(id);
        if(existingCustomer==null){
            throw new CustomerNotFoundException(id);
        }
        existingCustomer.setName(updated.getName());
        existingCustomer.setEmail(updated.getEmail());
        return existingCustomer;
    }

    public void delete(Long id){
        if (!store.containsKey(id)){
            throw new CustomerNotFoundException(id);
        }
        store.remove(id);
    }

}
