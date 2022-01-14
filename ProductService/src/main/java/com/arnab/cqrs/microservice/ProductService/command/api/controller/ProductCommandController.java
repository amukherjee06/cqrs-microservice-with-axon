package com.arnab.cqrs.microservice.ProductService.command.api.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.cqrs.microservice.ProductService.command.api.commands.CreateProductCommand;
import com.arnab.cqrs.microservice.ProductService.command.api.model.Product;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
	
	private CommandGateway commandGateway;
	
	public ProductCommandController(CommandGateway commandGateway) {
		this.commandGateway = commandGateway;
	}

	@PostMapping
	public String addProduct(@RequestBody Product product) {
		
		CreateProductCommand createProductCommand=
				CreateProductCommand.builder()
				.productId(UUID.randomUUID().toString())
				.name(product.getName())
				.price(product.getPrice())
				.quatity(product.getQuatity())
				.build();
		String result=commandGateway.sendAndWait(createProductCommand);
		
		return result;
	}

}
