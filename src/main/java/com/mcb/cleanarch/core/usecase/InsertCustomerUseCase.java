package com.mcb.cleanarch.core.usecase;

import com.mcb.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {
	
	void insert(Customer customer, String zipCode);

}
