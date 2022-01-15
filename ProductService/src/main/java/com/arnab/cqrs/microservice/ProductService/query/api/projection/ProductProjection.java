package com.arnab.cqrs.microservice.ProductService.query.api.projection;

import java.util.List;
import java.util.stream.Collectors;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.cqrs.microservice.ProductService.command.api.data.ProductEntity;
import com.arnab.cqrs.microservice.ProductService.command.api.data.ProductRepository;
import com.arnab.cqrs.microservice.ProductService.command.api.model.Product;
import com.arnab.cqrs.microservice.ProductService.query.api.queries.GetProductQuery;

@Component
public class ProductProjection {
	
	@Autowired
	private ProductRepository productRepository;
	
	@QueryHandler
	public List<Product> handle(GetProductQuery getProductQuery){
		
		List<ProductEntity> products=
				productRepository.findAll();
		
		List<Product> listOfProduct=
				products.stream()
				.map(product->Product
						.builder()
						.name(product.getName())
						.price(product.getPrice())
						.quatity(product.getQuatity())
						.build()
						)
				.collect(Collectors.toList());
		
		return listOfProduct;
	}

}
