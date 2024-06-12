package com.mcb.cleanarch.entrypoint.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.mcb.cleanarch.core.usecase.InsertCustomerUseCase;
import com.mcb.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.mcb.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.mcb.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.mcb.cleanarch.entrypoint.controller.response.CustomerResponse;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private InsertCustomerUseCase insertCustomerUseCase;

	@Autowired
	private FindCustomerByIdUseCase findCustomerByIdUseCase;

	@Autowired
	private UpdateCustomerUseCase updateCustomerUseCase;

	@Autowired
	private CustomerMapper customerMapper;

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
		var customer = customerMapper.toCustomer(customerRequest);
		insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findById(@PathParam("id") String id) {
		var customer = findCustomerByIdUseCase.find(id);
		var customerResponse = customerMapper.toCustomerResponse(customer);
		return ResponseEntity.ok().body(customerResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathParam("id") String id, @Valid @RequestBody CustomerRequest customerRequest) {
		var customer = customerMapper.toCustomer(customerRequest);
		customer.setId(id);
		updateCustomerUseCase.update(customer, customerRequest.getZipCode());
		return ResponseEntity.noContent().build();
	}

}
