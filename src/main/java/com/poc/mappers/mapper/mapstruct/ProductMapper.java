package com.poc.mappers.mapper.mapstruct;

import com.poc.mappers.dto.ProductDTO;
import com.poc.mappers.entity.Category;
import com.poc.mappers.entity.Product;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = { UUID.class })
public interface ProductMapper {

    @Mapping(target = "apresentation", source = "description")
    @Mapping(target = "brand.name", source = "brand")
    @Mapping(target = "brand.id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "category", source = "category", qualifiedByName = "toCategory")
    @Mapping(target = "barCode", ignore = true)
    Product toEntity(ProductDTO productDTO);

    @InheritConfiguration
    List<Product> toEntity(List<ProductDTO> productDTOs);

    @Named("toCategory")
    default Category toCategory(String name) {
        return Category.builder()
                .name(name)
                .build();
    }

}
