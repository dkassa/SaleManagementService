package com.SaleManagementService.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.SaleManagementService.Dto.CustomerDTO;
import com.SaleManagementService.Dto.SaleDto;
import com.SaleManagementService.Model.Products;
import com.SaleManagementService.Model.Sale;

import com.SaleManagementService.Repository.SaleRepository;
import com.SaleManagementService.ReturnObject.ReturnObjects;

@Service
public class SaleServiceImpl implements SaleService{
	
	
	@Autowired
	SaleRepository saleRespository;
	

	

	@Override
	public Sale updateSale(String orderId, Sale sale) {
		Optional<Sale> optionalSale=saleRespository.findById(orderId);
		
		if(optionalSale.isPresent()) {
			
			Products prod1=new Products();
			
			
			Sale data=optionalSale.get();
			data.setCustomerId(sale.getCustomerId());
			data.setNotes(sale.getNotes());
			 //sale.getProducts().forEach(products -> products.setSale(sale));
			//data.setProducts(sale.getProducts());
			data.setShippingAddress(sale.getShippingAddress());
			
			 return saleRespository.save(data);
			
		}
		return null;
		
	}

	@Override
	public Sale getSale(String orderId) {
		
		Optional<Sale> optionalGet=saleRespository.findById(orderId);
		
		if(optionalGet.isPresent()) {
			Sale singleData=optionalGet.get();
			return singleData;		
		}
		
		return null;
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	public ReturnObjects returnobject(String orderId) {
		
		Optional<Sale> order=saleRespository.findById(orderId);
		
		CustomerDTO customer=restTemplate.getForObject("http://localhost:8080/customers/get/" + order.get().getCustomerId() , CustomerDTO.class);
		
		ReturnObjects returnobj=new ReturnObjects();
		
		returnobj.setSale(order.get());
		returnobj.setCustomerDto(customer);
		
		return returnobj;
		
		
		
		
	}

	@Override
	public Sale createSale(Sale sale) {
		// TODO Auto-generated method stub
		
		
		  return saleRespository.save(sale);
		 
		
		 
	}

	
}
