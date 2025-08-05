package com.poc.mappers.dto;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseDTO {

	private List<ProductDTO> products;

}
