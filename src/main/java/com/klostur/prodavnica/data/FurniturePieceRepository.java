package com.klostur.prodavnica.data;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klostur.prodavnica.entities.FurniturePiece;

public interface FurniturePieceRepository extends JpaRepository<FurniturePiece, Long>{

	List<FurniturePiece> findByNameContains(String name);

	List<FurniturePiece> findByCodeContains(String code);

	List<FurniturePiece> findByPriceGreaterThanAndPriceLessThan(Integer greaterThan, Integer lessThan);

}
