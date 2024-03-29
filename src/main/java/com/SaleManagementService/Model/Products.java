package com.SaleManagementService.Model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products {
	
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="demo-lead")
	@GenericGenerator(name="demo-lead",strategy="com.SaleManagementService.Model.StringPrefixSequenceGenerator",parameters= {
			
			@Parameter(name=StringPrefixSequenceGenerator.INCREMENT_PARAM, value="1"),
			@Parameter(name=StringPrefixSequenceGenerator.value_prefix_parameter,value="PROD"),
			@Parameter(name=StringPrefixSequenceGenerator.number_format_parameter,value="%03d")
			
	})
	
	private String productId;
	private String name;
	private int quantity;
	private double price;
	
//	@JsonIgnore
//	@ManyToOne(fetch= FetchType.LAZY ,optional=false)
//	@JoinColumn(name="order_id",nullable=false)
//	private Sale sale;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "orderId",referencedColumnName="orderId")
    private  Sale sale;

	
	

}
