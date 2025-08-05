package com.poc.mappers.mapper.mapstruct;

import com.poc.mappers.dto.ProductDTO;
import com.poc.mappers.dto.PurchaseDTO;
import com.poc.mappers.entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseMapper {

	@Mapping(target = "date", expression = "java(java.time.LocalDateTime.now())")
	@Mapping(target = "amount", source = "products", qualifiedByName = "calculateAmount")
	Purchase toEntity(PurchaseDTO purchaseDTO);

	@Named("calculateAmount")
	default BigDecimal calculateAmount(List<ProductDTO> products) {
		return products == null ? BigDecimal.ZERO
				: products.stream().map(ProductDTO::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
