package com.mcb.cleanarch.core.usecase.impl;

import com.mcb.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.mcb.cleanarch.core.dataprovider.UpdateCustomer;
import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.mcb.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

	private final FindCustomerByIdUseCase findCustomerByIdUseCase;

	private final FindAddressByZipCode findAddressByZipCode;

	private final UpdateCustomer updateCustomer;

	public UpdateCustomerUseCaseImpl(
			FindCustomerByIdUseCase findCustomerByIdUseCase,
			FindAddressByZipCode findAddressByZipCode,
			UpdateCustomer updateCustomer) {
		this.findCustomerByIdUseCase = findCustomerByIdUseCase;
		this.findAddressByZipCode = findAddressByZipCode;
		this.updateCustomer = updateCustomer;
	}

	@Override
	public void update(Customer customer, String zipCode) {
		findCustomerByIdUseCase.find(customer.getId());
		var address = findAddressByZipCode.find(zipCode);
		customer.setAddress(address);
		updateCustomer.update(customer);
	}

}
