package com.SaleManagementService.ReturnObject;

import com.SaleManagementService.Dto.CustomerDTO;
import com.SaleManagementService.Model.Sale;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnObjects {
	Sale sale;
	CustomerDTO customerDto;

}
