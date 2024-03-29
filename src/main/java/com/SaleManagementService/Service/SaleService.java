package com.SaleManagementService.Service;


import org.hibernate.mapping.List;

import com.SaleManagementService.Dto.SaleDto;
import com.SaleManagementService.Model.Products;
import com.SaleManagementService.Model.Sale;

public interface SaleService {
	
//	/create (POST): Create a new sales order.
//	● /update/{orderId} (PUT): Update an existing sales order.
//	● /get/{orderId} (GET): Retrieve order details.
	
	
	public Sale createSale(Sale sale);
	Sale updateSale(String orderId,Sale sale);
	Sale getSale(String orderId);
	
	
	
	
	

}
