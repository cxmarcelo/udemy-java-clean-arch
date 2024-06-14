package com.mcb.cleanarch.entrypoint.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.mcb.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.mcb.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.mcb.cleanarch.entrypoint.consumer.message.CustomerMessage;

@Component
public class ReceiveValidatedCpfConsumer {

	@Autowired
	private UpdateCustomerUseCase updateCustomerUseCase;

	@Autowired
	private CustomerMessageMapper customerMessageMapper;

	@KafkaListener(topics = "tp-cpf-validated", groupId = "mcb")
	public void receive(CustomerMessage customerMessage) {
		var customer = customerMessageMapper.toCustomer(customerMessage);
		updateCustomerUseCase.update(customer, customerMessage.getZipCode());
	}

}
