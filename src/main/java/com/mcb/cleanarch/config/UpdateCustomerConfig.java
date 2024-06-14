package com.mcb.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.mcb.cleanarch.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.mcb.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.mcb.cleanarch.dataprovider.updateCustomerImpl;

@Configuration
public class UpdateCustomerConfig {

	@Bean
	UpdateCustomerUseCaseImpl updateCustomerUseCaseImpl(
			FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl,
			FindAddressByZipCodeImpl findAddressByZipCodeImpl,
			updateCustomerImpl updateCustomerImpl
			) {
		return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCaseImpl, findAddressByZipCodeImpl, updateCustomerImpl);
	}

}
