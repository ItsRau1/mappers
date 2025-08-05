package com.poc.mappers.entity;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Category {

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;

}
