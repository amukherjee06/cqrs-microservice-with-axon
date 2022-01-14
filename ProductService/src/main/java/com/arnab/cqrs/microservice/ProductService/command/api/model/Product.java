package com.arnab.cqrs.microservice.ProductService.command.api.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private String name;
	private BigDecimal price;
	private Integer quatity;
	
}
