package com.mcb.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.mcb.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.mcb.cleanarch.dataprovider.InsertCustomerImpl;

@Configuration
public class InsertCustomerConfig {

	@Bean
	InsertCustomerUseCaseImpl insertCustomerUseCaseImpl(
			FindAddressByZipCodeImpl findAddressByZipCodeImpl,
			InsertCustomerImpl insertCustomerImpl) {
		return new InsertCustomerUseCaseImpl(findAddressByZipCodeImpl, insertCustomerImpl);
	}

}
