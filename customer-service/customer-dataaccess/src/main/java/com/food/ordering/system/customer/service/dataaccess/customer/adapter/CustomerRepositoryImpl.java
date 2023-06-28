package com.food.ordering.system.customer.service.dataaccess.customer.adapter;

import com.food.ordering.system.customer.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.food.ordering.system.customer.service.dataaccess.customer.repository.CustomerJpaRepository;
import com.food.ordering.system.customer.service.domain.entity.Customer;
import com.food.ordering.system.customer.service.domain.ports.output.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository, CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDataAccessMapper.customerEntityToCustomer(customerJpaRepository.save(customerDataAccessMapper.customerToCustomerEntity(customer)));
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerJpaRepository.findById(UUID.fromString(id)).map(customerDataAccessMapper::customerEntityToCustomer);
    }
}
