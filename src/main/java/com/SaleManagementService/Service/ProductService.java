package com.SaleManagementService.Service;

import java.util.List;

import com.SaleManagementService.Model.Products;

public interface ProductService {
	
	Products createProduct(Products product);
	List<Products> getAllProducts();
	Products getProductById(String productId);

}
