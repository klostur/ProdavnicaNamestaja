package com.klostur.prodavnica.TestJPA;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.klostur.prodavnica.data.FurniturePieceRepository;
import com.klostur.prodavnica.entities.FurniturePiece;
import com.klostur.prodavnica.entities.FurnitureType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestJPA {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	FurniturePieceRepository furniturePieceRepository;
	
	@Before
	public void setup() {
		FurnitureType t = this.entityManager.persist(new FurnitureType("Sofa"));
		this.entityManager.persist(new FurniturePiece("Valerijana", 24000, "ZG-D3213", t));
		entityManager.persist(new FurniturePiece("Mikonos", 36000, "ZR-3142", t));
		entityManager.persist(new FurniturePiece("Grecija", 45880, "WT-5262", t));
		entityManager.persist(new FurniturePiece("Retkon", 120000, "RQW-1315D", t));
	}
	
	@Test
	public void testFindAll() {
		List<FurniturePiece> pieces = this.furniturePieceRepository.findAll();
		assertEquals(4, pieces.size());
		assertEquals("Valerijana", pieces.get(0).getName());
	}
	@Test
	public void testFindByNameContains() {
		List<FurniturePiece> pieces = furniturePieceRepository.findByNameContains("ja");
		assertEquals(2, pieces.size());
		assertEquals("Valerijana", pieces.get(0).getName());
	}
	@Test
	public void testFindByCodeContains() {
		List<FurniturePiece> pieces = furniturePieceRepository.findByCodeContains("3");
		assertEquals(3, pieces.size());
		assertEquals("Valerijana", pieces.get(0).getName());
	}
	@Test
	public void testFindByPriceGreaterThanAndPriceLessThan() {
		List<FurniturePiece> pieces = furniturePieceRepository.findByPriceGreaterThanAndPriceLessThan(25000, 50000);
		assertEquals(2, pieces.size());
		assertEquals("Mikonos", pieces.get(0).getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
