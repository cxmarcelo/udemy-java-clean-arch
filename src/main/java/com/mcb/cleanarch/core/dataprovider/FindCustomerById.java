package com.mcb.cleanarch.core.dataprovider;

import java.util.Optional;

import com.mcb.cleanarch.core.domain.Customer;

public interface FindCustomerById {

	Optional<Customer> find(final String id);

}
