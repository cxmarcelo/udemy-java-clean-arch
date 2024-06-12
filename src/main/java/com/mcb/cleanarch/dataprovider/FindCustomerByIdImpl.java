package com.mcb.cleanarch.dataprovider;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.dataprovider.FindCustomerById;
import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.dataprovider.repository.CustomerRepository;
import com.mcb.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;

@Component
public class FindCustomerByIdImpl implements FindCustomerById {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerEntityMapper customerEntityMapper;

	@Override
	public Optional<Customer> find(String id) {
		var optCustomerEntity = customerRepository.findById(id);
		return optCustomerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
	}

}
