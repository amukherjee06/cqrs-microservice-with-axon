package com.arnab.cqrs.microservice.ProductService.query.api;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.cqrs.microservice.ProductService.command.api.model.Product;
import com.arnab.cqrs.microservice.ProductService.query.api.queries.GetProductQuery;

@RestController
@RequestMapping("/products")
public class ProductQueryController {
	
	@Autowired
	private QueryGateway queryGateway;
	
	@GetMapping
	public List<Product> getAllProducts(){
		GetProductQuery getProductQuery=new GetProductQuery();
		List<Product> listOfProducts=queryGateway
				.query(getProductQuery, ResponseTypes.multipleInstancesOf(Product.class))
				.join();
		return null;
	}

}
