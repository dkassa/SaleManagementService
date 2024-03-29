package com.SaleManagementService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SaleManagementService.Model.Products;

public interface ProductRepository extends JpaRepository<Products, String>{

}
