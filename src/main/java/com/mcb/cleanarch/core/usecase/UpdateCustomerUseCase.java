package com.mcb.cleanarch.core.usecase;

import com.mcb.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {

	void update(Customer customer, String zipCode);

}
