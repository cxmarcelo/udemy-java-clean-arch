package com.mcb.cleanarch.entrypoint.consumer.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.entrypoint.consumer.message.CustomerMessage;

@Component
public class CustomerMessageMapper {

	public Customer toCustomer(CustomerMessage customerMessage) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerMessage, customer);
		return customer;
	}

}
