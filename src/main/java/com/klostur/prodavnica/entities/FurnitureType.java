package com.klostur.prodavnica.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FurnitureType {
	@Id
	@GeneratedValue
	private Long id;
	private String typeName;
	
	public FurnitureType(Long id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}

	public FurnitureType() {
		super();
	}


	public FurnitureType(String typeName) {
		this.typeName = typeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
