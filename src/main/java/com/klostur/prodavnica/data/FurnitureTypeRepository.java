package com.klostur.prodavnica.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klostur.prodavnica.entities.FurnitureType;

public interface FurnitureTypeRepository extends JpaRepository<FurnitureType, Long>{

}
