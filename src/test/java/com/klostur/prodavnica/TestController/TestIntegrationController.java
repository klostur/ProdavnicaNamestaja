package com.klostur.prodavnica.TestController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.klostur.prodavnica.web.controller.FurniturePieceController;
import com.klostur.prodavnica.web.dto.FurniturePieceDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestIntegrationController {
	@Autowired
	FurniturePieceController furniturePieceController;
	
	@Test
	public void testGetFurniture() {
		ResponseEntity<List<FurniturePieceDTO>> responseEntity = furniturePieceController.findAll();
		List<FurniturePieceDTO> list = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(6, list.size());
	}
	@Test
	public void testGetFurnitureByCode() {
		ResponseEntity<List<FurniturePieceDTO>> responseEntity = furniturePieceController.findByCodeContains("x");
		List<FurniturePieceDTO> list = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, list.size());
	}
	@Test
	public void testFindByPrice() {
		ResponseEntity<List<FurniturePieceDTO>> responseEntity = furniturePieceController.findByPrice(25000, 100000);
		List<FurniturePieceDTO> list = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(3, list.size());
	}
	@Test
	public void testFindByPriceTooMuch() {
		ResponseEntity<List<FurniturePieceDTO>> responseEntity = furniturePieceController.findByPrice(250000, 1000000);
		List<FurniturePieceDTO> list = responseEntity.getBody();
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		assertNull(list);
	}
}
