package com.SaleManagementService.Model;


import static jakarta.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Sale {
	
@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="demo-lead")
	@GenericGenerator(name="demo-lead",strategy="com.SaleManagementService.Model.StringPrefixSequenceGenerator",parameters= {
			
			@Parameter(name=StringPrefixSequenceGenerator.INCREMENT_PARAM, value="1"),
			@Parameter(name=StringPrefixSequenceGenerator.value_prefix_parameter,value="ORDER"),
			@Parameter(name=StringPrefixSequenceGenerator.number_format_parameter,value="%06d")
			
	})

	
	

private String orderId;	

private String customerId;	
//@JsonIgnore
//@OneToMany(cascade=CascadeType.ALL, fetch= FetchType.LAZY,mappedBy="sale")
//private Set<Products> products;

//@JsonIgnore
//
//@OneToMany(cascade=CascadeType.MERGE,fetch= FetchType.LAZY,mappedBy="sale")
////@JoinColumn(name="orderId", nullable = false)
//private List<Products> products;

private double discount;

private ShippingAddress shippingAddress;
private String  notes;




}
