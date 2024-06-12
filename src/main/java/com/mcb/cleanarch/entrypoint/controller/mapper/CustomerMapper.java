package com.mcb.cleanarch.entrypoint.controller.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.entrypoint.controller.request.CustomerRequest;

@Component
public class CustomerMapper {

	public Customer toCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequest, customer);
		return customer;
	}

}
