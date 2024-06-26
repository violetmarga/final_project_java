package com.final_project_java.service.impl;

import com.final_project_java.model.Customer;
import com.final_project_java.repository.CustomerRepository;
import com.final_project_java.service.CustomerService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {

        return customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        String password = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt());
        customer.setPassword(password);

        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        String password = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt());
        customer.setPassword(password);

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {

        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getCustomersByName(String name) {

        return customerRepository.getCustomersByName(name);
    }
}
