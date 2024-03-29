package com.SaleManagementService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SaleManagementService.Model.Sale;

public interface SaleRepository extends JpaRepository<Sale, String>{

}
