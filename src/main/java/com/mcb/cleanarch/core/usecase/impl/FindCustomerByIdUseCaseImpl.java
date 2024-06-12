package com.mcb.cleanarch.core.usecase.impl;

import com.mcb.cleanarch.core.dataprovider.FindCustomerById;
import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

	private final FindCustomerById findCustomerById;

	public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
		this.findCustomerById = findCustomerById;
	}

	@Override
	public Customer find(String id) {
		return findCustomerById.find(id).orElseThrow(() -> new RuntimeException("User not found."));
	}

}
