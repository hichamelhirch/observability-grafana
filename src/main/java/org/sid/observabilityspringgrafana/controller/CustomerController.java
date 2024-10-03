package org.sid.observabilityspringgrafana.controller;


import org.sid.observabilityspringgrafana.entities.Customer;
import org.sid.observabilityspringgrafana.model.Post;
import org.sid.observabilityspringgrafana.repository.CustomerRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final RestClient restClient;
    public CustomerController(CustomerRepository customerRepository, RestClient.Builder restClient) {
        this.customerRepository = customerRepository;
        this.restClient = restClient
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Customer getCustomerByID(Long id){
        return customerRepository.findById(id).get();
    }
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    @GetMapping
    public String msg(){
        return "Welcome";
    }
}
