package com.mcb.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.mcb.cleanarch.dataprovider.FindCustomerByIdImpl;

@Configuration
public class FindCustomerByIdConfig {

	@Bean
	FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl(
			FindCustomerByIdImpl findCustomerByIdImpl) {
		return new FindCustomerByIdUseCaseImpl(findCustomerByIdImpl);
	}

}
