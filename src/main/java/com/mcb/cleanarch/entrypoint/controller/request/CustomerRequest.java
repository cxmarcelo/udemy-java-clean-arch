package com.mcb.cleanarch.entrypoint.controller.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CustomerRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String cpf;

	@NotBlank
	private String zipCode;

}
