package com.arnab.cqrs.microservice.ProductService.command.api.aggregate;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.arnab.cqrs.microservice.ProductService.command.api.commands.CreateProductCommand;
import com.arnab.cqrs.microservice.ProductService.command.api.events.ProductCreatedEvent;

@Aggregate
public class ProductAggregate {
	
	@AggregateIdentifier
	private String productId;	
	private String name;
	private BigDecimal price;
	private Integer quatity;
	
	public ProductAggregate() {
	}
	
	@CommandHandler
	public ProductAggregate(CreateProductCommand createProductCommand) {
		//perform all the validations over here
		ProductCreatedEvent productCreatedEvent
		=new ProductCreatedEvent();
		
		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
		
		AggregateLifecycle.apply(productCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		
		this.name=productCreatedEvent.getName();
		this.price=productCreatedEvent.getPrice();
		this.quatity=productCreatedEvent.getQuatity();
		this.productId=productCreatedEvent.getProductId();
	}

}
