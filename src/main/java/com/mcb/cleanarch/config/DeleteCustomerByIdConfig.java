package com.mcb.cleanarch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcb.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.mcb.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.mcb.cleanarch.dataprovider.DeleteCustomerByIdImpl;

@Configuration
public class DeleteCustomerByIdConfig {

	@Bean
	DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCaseImpl(
			FindCustomerByIdUseCaseImpl findCustomerByIdUseCaseImpl,
			DeleteCustomerByIdImpl deleteCustomerByIdImpl
			) {
		return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCaseImpl, deleteCustomerByIdImpl);
	}

}
