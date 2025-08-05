package com.poc.mappers.mapper.mapstruct;

import com.poc.mappers.dto.ProductDTO;
import com.poc.mappers.dto.PurchaseDTO;
import com.poc.mappers.entity.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PurchaseMapperTest {

	@Autowired
	private PurchaseMapper purchaseMapper;

	@Test
	@DisplayName("Deve ser possível converter um PurchaseDTO para um Purchase")
	void deveSerPossivelConverterUmPurchaseDTOParaUmPurchase() {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName("Test Product");
		productDTO.setPrice(new BigDecimal("10.00"));

		PurchaseDTO dto = new PurchaseDTO();
		dto.setProducts(Collections.singletonList(productDTO));

		Purchase entity = purchaseMapper.toEntity(dto);

		assertNotNull(entity);
		assertNotNull(entity.getDate());
		assertEquals(new BigDecimal("10.00"), entity.getAmount());
		assertNotNull(entity.getProducts());
		assertEquals(1, entity.getProducts().size());
	}

}
