package com.mcb.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.cleanarch.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.mcb.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.mcb.cleanarch.dataprovider.InsertCustomerImpl;
import com.mcb.cleanarch.dataprovider.SendCpfForValidationImpl;

@Configuration
public class InsertCustomerConfig {

	@Bean
	InsertCustomerUseCaseImpl insertCustomerUseCaseImpl(
			FindAddressByZipCodeImpl findAddressByZipCodeImpl,
			InsertCustomerImpl insertCustomerImpl,
			SendCpfForValidationImpl sendCpfForValidationImpl) {
		return new InsertCustomerUseCaseImpl(findAddressByZipCodeImpl, insertCustomerImpl, sendCpfForValidationImpl);
	}

}
