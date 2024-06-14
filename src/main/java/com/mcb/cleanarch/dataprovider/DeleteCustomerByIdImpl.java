package com.mcb.cleanarch.dataprovider;

import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.dataprovider.DeleteCustomerById;
import com.mcb.cleanarch.dataprovider.repository.CustomerRepository;

@Component
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

	private CustomerRepository customerRepository;

	@Override
	public void delete(String id) {
		customerRepository.deleteById(id);
	}

}
