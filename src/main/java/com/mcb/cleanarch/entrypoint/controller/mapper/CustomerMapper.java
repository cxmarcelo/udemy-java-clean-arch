package com.mcb.cleanarch.entrypoint.controller.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.mcb.cleanarch.entrypoint.controller.response.AddressResponse;
import com.mcb.cleanarch.entrypoint.controller.response.CustomerResponse;

@Component
public class CustomerMapper {

	public Customer toCustomer(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequest, customer);
		return customer;
	}

	public CustomerResponse toCustomerResponse(Customer customer) {
		CustomerResponse customerResponse = new CustomerResponse();
		BeanUtils.copyProperties(customer, customerResponse);

		AddressResponse addressResponse = new AddressResponse();
		BeanUtils.copyProperties(customer.getAddress(), addressResponse);

		customerResponse.setAddress(addressResponse);

		return customerResponse;
	}

}
