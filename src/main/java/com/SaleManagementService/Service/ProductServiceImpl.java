package com.SaleManagementService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SaleManagementService.Model.Products;
import com.SaleManagementService.Repository.ProductRepository;



@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	ProductRepository productRepo;
	

	@Override
	public Products createProduct(Products product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}
	
	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Products getProductById(String productId) {
		// TODO Auto-generated method stub
		
		Optional<Products> optionalProduct=productRepo.findById(productId);
		
		if(optionalProduct.isPresent()) {
			Products prod=optionalProduct.get();
			return prod;
		}
		return null;
	}

}
