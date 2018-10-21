package com.klostur.prodavnica.web.dto;

import com.klostur.prodavnica.entities.FurnitureType;

public class FurniturePieceDTO {
	private Long id;
	private String name;
	private int price;
	private String code;
	private FurnitureType furnitureType;
	
	public FurniturePieceDTO(Long id, String name, int price, String code, FurnitureType furnitureType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.code = code;
		this.furnitureType = furnitureType;
	}
	public FurniturePieceDTO() {
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
