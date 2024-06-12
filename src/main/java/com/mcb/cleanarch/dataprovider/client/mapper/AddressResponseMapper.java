package com.mcb.cleanarch.dataprovider.client.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.domain.Address;
import com.mcb.cleanarch.dataprovider.client.response.AddressResponse;

@Component
public class AddressResponseMapper {

	public Address toAddress(AddressResponse addressResponse) {
		Address address = new Address();
		BeanUtils.copyProperties(addressResponse, address);
		return address;
	}

}
