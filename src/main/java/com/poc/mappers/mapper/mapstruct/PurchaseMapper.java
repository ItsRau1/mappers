package com.poc.mappers.mapper.mapstruct;

import com.poc.mappers.dto.PurchaseDTO;
import com.poc.mappers.entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProductMapper.class })
public interface PurchaseMapper {

	@Mapping(target = "products", source = "products", qualifiedByName = "toEntity")
	Purchase toEntity(PurchaseDTO purchaseDTO);

}
