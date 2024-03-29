package com.SaleManagementService.Controllers;

import java.util.ArrayList;


import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SaleManagementService.Dto.SaleDto;
import com.SaleManagementService.Model.Products;
import com.SaleManagementService.Model.Sale;
import com.SaleManagementService.Service.SaleService;
import com.SaleManagementService.Service.SaleServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/orders")
public class SaleControllers {
	
	@Autowired
	SaleService saleService;
	
	@Autowired
	SaleServiceImpl serviceImpl;
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewOrder(@RequestBody Sale sale){
		
		//System.out.println(saledto);
		
		//System.out.println("sale" + saledto.getNotes());
		
		
		
//		double total=0D;
//		for(Products prod1: saledto.getProductId() ) {
//			
//			
//			total+=(prod1.getPrice()*prod1.getQuantity());
//			
//		}
		SaleDto dto=new SaleDto();
		
		Sale dto1=new Sale();
		dto.setCustomerId(sale.getCustomerId());
		dto.setNotes(sale.getNotes());
		dto.setShippingAddress(sale.getShippingAddress());
		dto.setStatus("open");
		dto.setTotalAmount(50);
		//dto.setProductId(sale.getProductId());
		
		
		
		saleService.createSale(sale);	 
			
			  //sale.getProducts().forEach(products -> products.setSale(sale));
		return new ResponseEntity<>(dto,HttpStatus.CREATED);
			
		
		
		
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateOrder(@PathVariable String orderId,@RequestBody Sale sale){
		
		
		try {
			return new ResponseEntity<>(saleService.updateSale(orderId, sale),HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
			
		}
		
	}
	
	@GetMapping("/get/{orderId}")
	@CircuitBreaker(name="sale",fallbackMethod="fallBack")
	public ResponseEntity<?>empSaleProdById(@PathVariable String orderId){
		
		return new ResponseEntity<>(serviceImpl.returnobject(orderId),HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> fallBack(Exception e){
		
		return new ResponseEntity<>("try again later",HttpStatus.OK);
	}

}
