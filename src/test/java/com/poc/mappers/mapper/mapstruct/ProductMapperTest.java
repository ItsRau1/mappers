package com.poc.mappers.mapper.mapstruct;

import com.poc.mappers.dto.ProductDTO;
import com.poc.mappers.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {

	@Autowired
	private ProductMapper productMapper;

	@Test
	@DisplayName("Deve ser possível converter um ProductDTO para um Product")
	void deveSerPossivelConverterUmProductDTOParaUmProduct() {
		ProductDTO dto = new ProductDTO();
		dto.setName("Test Product");
		dto.setDescription("Test Description");
		dto.setPrice(new BigDecimal("19.99"));
		dto.setBrand("Test Brand");
		dto.setCategory("Test Category");

		Product entity = productMapper.toEntity(dto);

		assertNotNull(entity);
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getDescription(), entity.getApresentation());
		assertEquals(dto.getPrice(), entity.getPrice());
		assertNotNull(entity.getBrand());
		assertEquals(dto.getBrand(), entity.getBrand().getName());
		assertNotNull(entity.getBrand().getId());
		assertNotNull(entity.getCategory());
		assertEquals(dto.getCategory(), entity.getCategory().getName());
		assertNull(entity.getBarCode());
	}

	@Test
	@DisplayName("Deve ser possível converter uma lista de ProductDTO para uma lista de Product")
	void deveSerPossivelConverterUmaListaDeProductDTOParaUmaListaDeProduct() {
		ProductDTO dto = new ProductDTO();
		dto.setName("Test Product");
		dto.setDescription("Test Description");
		dto.setPrice(new BigDecimal("19.99"));
		dto.setBrand("Test Brand");
		dto.setCategory("Test Category");

		List<Product> entityList = productMapper.toEntity(Collections.singletonList(dto));

		assertNotNull(entityList);
		assertEquals(1, entityList.size());

		Product entity = entityList.getFirst();
		assertNotNull(entity);
		assertEquals(dto.getName(), entity.getName());
		assertEquals(dto.getDescription(), entity.getApresentation());
		assertEquals(dto.getPrice(), entity.getPrice());
		assertNotNull(entity.getBrand());
		assertEquals(dto.getBrand(), entity.getBrand().getName());
		assertNotNull(entity.getBrand().getId());
		assertNotNull(entity.getCategory());
		assertEquals(dto.getCategory(), entity.getCategory().getName());
		assertNull(entity.getBarCode());
	}

}
