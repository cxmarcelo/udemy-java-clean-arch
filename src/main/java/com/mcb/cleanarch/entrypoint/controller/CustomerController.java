package com.mcb.cleanarch.entrypoint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.cleanarch.core.usecase.InsertCustomerUseCase;
import com.mcb.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.mcb.cleanarch.entrypoint.controller.request.CustomerRequest;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private InsertCustomerUseCase insertCustomerUseCase;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
		var customer = customerMapper.toCustomer(customerRequest);
		insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}
	
}
