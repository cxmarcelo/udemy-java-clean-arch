package com.mcb.cleanarch.core.dataprovider;

import com.mcb.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
	
	Address find(final String zipCode); 

}
