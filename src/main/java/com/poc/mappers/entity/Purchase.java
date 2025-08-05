package com.poc.mappers.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Purchase {

	private List<Product> products;

	private BigDecimal amount;

	private LocalDateTime date;

}
