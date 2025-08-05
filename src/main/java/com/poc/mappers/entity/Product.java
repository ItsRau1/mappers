package com.poc.mappers.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {

    private String id;

    private String name;

    private String apresentation;

    private BigDecimal price;

    private Category category;

    private Brand brand;

    private String barCode;

}
