package com.SaleManagementService.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SaleManagementService.Model.Products;
import com.SaleManagementService.Service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductControllers {
	
	@Autowired
	 ProductService productimpl;
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@RequestBody Products products) {
		
		return new ResponseEntity<> (productimpl.createProduct(products),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/allProducts")
	public ResponseEntity<?> getAllProducts(){
		
		return new ResponseEntity<>(productimpl.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/singleProduct/{productId}")
	public ResponseEntity<?> getProductById(String productId){
		
		return new ResponseEntity<>(productimpl.getProductById(productId),HttpStatus.OK);
	}

}
