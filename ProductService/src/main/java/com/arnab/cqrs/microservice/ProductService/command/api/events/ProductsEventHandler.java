package com.arnab.cqrs.microservice.ProductService.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.cqrs.microservice.ProductService.command.api.data.ProductEntity;
import com.arnab.cqrs.microservice.ProductService.command.api.data.ProductRepository;

@Component
public class ProductsEventHandler {
	
	@Autowired
	private ProductRepository repository;
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		
		ProductEntity product=new ProductEntity();
		BeanUtils.copyProperties(event, product);
		
		repository.save(product);
	}

}
