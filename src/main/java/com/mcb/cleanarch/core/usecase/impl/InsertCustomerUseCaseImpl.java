package com.mcb.cleanarch.core.usecase.impl;

import com.mcb.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.mcb.cleanarch.core.dataprovider.InsertCustomer;
import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase{

	private final FindAddressByZipCode findAdressByZipCode;
	
	private final InsertCustomer insertCustomer;

	public InsertCustomerUseCaseImpl(FindAddressByZipCode findAdressByZipCode, InsertCustomer insertCustomer) {
		this.findAdressByZipCode = findAdressByZipCode;
		this.insertCustomer = insertCustomer;
	}

	@Override
	public void insert(Customer customer, String zipCode) {
		var address = findAdressByZipCode.find(zipCode);
		customer.setAddress(address);
		
		insertCustomer.insert(customer);
	}

}
