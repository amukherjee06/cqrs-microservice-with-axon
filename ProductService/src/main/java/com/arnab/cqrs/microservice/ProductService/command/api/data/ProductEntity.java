package com.arnab.cqrs.microservice.ProductService.command.api.data;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductEntity {

	@Id
	private String productId;	
	private String name;
	private BigDecimal price;
	private Integer quatity;
	
}
