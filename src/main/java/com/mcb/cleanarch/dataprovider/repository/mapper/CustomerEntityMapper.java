package com.mcb.cleanarch.dataprovider.repository.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.domain.Customer;
import com.mcb.cleanarch.dataprovider.repository.entity.AddressEntity;
import com.mcb.cleanarch.dataprovider.repository.entity.CustomerEntity;

@Component
public class CustomerEntityMapper {

	public CustomerEntity toCustomerEntity(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customer, customerEntity);

		AddressEntity addressEntity = new AddressEntity();
		BeanUtils.copyProperties(customer.getAddress(), addressEntity);

		customerEntity.setAddress(addressEntity);

		return customerEntity;
	}

}
