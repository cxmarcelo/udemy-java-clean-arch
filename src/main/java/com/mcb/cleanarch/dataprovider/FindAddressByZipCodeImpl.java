package com.mcb.cleanarch.dataprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.mcb.cleanarch.core.domain.Address;
import com.mcb.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.mcb.cleanarch.dataprovider.client.mapper.AddressResponseMapper;

@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

	@Autowired
	private FindAddressByZipCodeClient findAddressByZipCodeClient;

	@Autowired
	private AddressResponseMapper addressResponseMapper;

	@Override
	public Address find(String zipCode) {
		var addressResponse = findAddressByZipCodeClient.find(zipCode);
		return addressResponseMapper.toAddress(addressResponse);
	}

}
