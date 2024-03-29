package com.SaleManagementService.Dto;

import org.hibernate.mapping.List;

import com.SaleManagementService.Model.Products;
import com.SaleManagementService.Model.ShippingAddress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {
	
	private String customerId;	
	
	

	private ShippingAddress shippingAddress;
	private String  notes;
	private String productId;
	private double totalAmount;
	private String Status;
	
	


}
