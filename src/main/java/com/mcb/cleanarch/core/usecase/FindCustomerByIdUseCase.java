package com.mcb.cleanarch.core.usecase;

import com.mcb.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {

	Customer find(final String id);

}
