package com.poc.mappers.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private String name;

    private String description;

    private BigDecimal price;

    private String category;

    private String brand;

    private String barCode;

}
