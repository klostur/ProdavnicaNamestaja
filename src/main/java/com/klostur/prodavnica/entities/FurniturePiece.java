package com.klostur.prodavnica.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FurniturePiece {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int price;
	private String code;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private FurnitureType furnitureType;
	
	public FurniturePiece(Long id, String name, int price, String code, FurnitureType furnitureType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.code = code;
		this.furnitureType = furnitureType;
	}
	
	public FurniturePiece() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public FurnitureType getFurnitureType() {
		return furnitureType;
	}

	public void setFurnitureType(FurnitureType furnitureType) {
		this.furnitureType = furnitureType;
	}
	
	
}
