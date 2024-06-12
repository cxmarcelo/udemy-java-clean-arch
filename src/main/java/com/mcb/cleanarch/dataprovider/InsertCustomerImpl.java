package com.mcb.cleanarch.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.dataprovider.InsertCustomer;
import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.dataprovider.repository.CustomerRepository;
import com.mcb.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;

@Component
public class InsertCustomerImpl implements InsertCustomer {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerEntityMapper customerEntityMapper;

	@Override
	public void insert(Customer customer) {
		var customerEntity = customerEntityMapper.toCustomerEntity(customer);
		customerRepository.save(customerEntity);
	}

}
