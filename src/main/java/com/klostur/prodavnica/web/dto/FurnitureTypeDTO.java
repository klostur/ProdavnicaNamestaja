package com.klostur.prodavnica.web.dto;

public class FurnitureTypeDTO {
	private Long id;
	private String name;
	
	public FurnitureTypeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public FurnitureTypeDTO() {
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
	
	
}
