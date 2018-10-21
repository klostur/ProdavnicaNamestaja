package com.klostur.prodavnica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.klostur.prodavnica.data.FurniturePieceRepository;
import com.klostur.prodavnica.entities.FurniturePiece;

@Component
public class FurniturePieceService {
	@Autowired
	FurniturePieceRepository furniturePieceRepository;

	public List<FurniturePiece> findAll() {
		return furniturePieceRepository.findAll();
	}

	public FurniturePiece findOne(Long id) {
		return furniturePieceRepository.findOne(id);
	}

	public FurniturePiece save(FurniturePiece piece) {
		return furniturePieceRepository.save(piece);
	}

	public void delete(FurniturePiece piece) {
		furniturePieceRepository.delete(piece);
	}

	public List<FurniturePiece> findByNameContains(String name) {
		return furniturePieceRepository.findByNameContains(name);
	}

	public List<FurniturePiece> findByCodeContains(String code) {
		return furniturePieceRepository.findByCodeContains(code);
	}

	public List<FurniturePiece> findByPrice(Integer greaterThan, Integer lessThan) {
		return furniturePieceRepository.findByPriceGreaterThanAndPriceLessThan(greaterThan, lessThan);
	}
	
	
}
