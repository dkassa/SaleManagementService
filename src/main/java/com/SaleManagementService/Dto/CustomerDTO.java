package com.SaleManagementService.Dto;

import com.CustomerManagementService.Model.Address;
import com.CustomerManagementService.Model.CustomFields;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Address address;
	private String notes;
	private CustomFields customfields;
	
}
