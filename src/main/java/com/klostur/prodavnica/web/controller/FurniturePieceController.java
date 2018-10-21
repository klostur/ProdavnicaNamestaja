package com.klostur.prodavnica.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klostur.prodavnica.entities.FurniturePiece;
import com.klostur.prodavnica.service.FurniturePieceService;
import com.klostur.prodavnica.web.dto.FurniturePieceDTO;

@RestController
public class FurniturePieceController {
	@Autowired
	FurniturePieceService furniturePieceService;

	@GetMapping(value = "api/furniture")
	public ResponseEntity<List<FurniturePieceDTO>> findAll() {
		List<FurniturePiece> pieces = furniturePieceService.findAll();
		List<FurniturePieceDTO> retVal = convertListToDTO(pieces);

		return new ResponseEntity<List<FurniturePieceDTO>>(retVal, HttpStatus.OK);
	}

	@GetMapping(value = "/api/furniture/{id}")
	public ResponseEntity<FurniturePieceDTO> findOne(@PathVariable Long id) {
		FurniturePieceDTO retVal = convertPieceToDTO(furniturePieceService.findOne(id));
		return new ResponseEntity<FurniturePieceDTO>(retVal, HttpStatus.OK);
	}

	@PostMapping(value = "/api/furniture")
	public ResponseEntity<FurniturePieceDTO> save(@RequestBody FurniturePieceDTO furniturePieceDTO) {
		FurniturePiece piece = new FurniturePiece(null, furniturePieceDTO.getName(), 
				furniturePieceDTO.getPrice(), furniturePieceDTO.getCode(), furniturePieceDTO.getFurnitureType());
		FurniturePiece p = furniturePieceService.save(piece);
		if (p == null) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<FurniturePieceDTO>(furniturePieceDTO, HttpStatus.OK);
		}
	}
	@PutMapping(value = "/api/furniture/{id}")
	public ResponseEntity<FurniturePieceDTO> findOne(@PathVariable Long id, @RequestBody FurniturePieceDTO furniturePieceDTO) {
		FurniturePiece piece = furniturePieceService.findOne(id);
		if (piece == null) {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		} else {
			piece.setId(id);
			piece.setName(furniturePieceDTO.getName());
			piece.setCode(furniturePieceDTO.getCode());
			piece.setPrice(furniturePieceDTO.getPrice());
			piece.setFurnitureType(furniturePieceDTO.getFurnitureType());
			
			piece = furniturePieceService.save(piece);
			
			return new ResponseEntity<FurniturePieceDTO>(furniturePieceDTO, HttpStatus.OK);
		}
	}
	@DeleteMapping(value = "/api/furniture/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		FurniturePiece piece = furniturePieceService.findOne(id);
		if (piece != null) {
			furniturePieceService.delete(piece);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value = "/api/furniture", params = "name")
	public ResponseEntity<List<FurniturePieceDTO>> findByNameContains(@RequestParam String name){
		List<FurniturePiece> pieces = furniturePieceService.findByNameContains(name);
		List<FurniturePieceDTO> retVal = convertListToDTO(pieces);
		if(retVal.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FurniturePieceDTO>>(retVal, HttpStatus.OK);
	}
	
	@GetMapping(value = "/api/furniture", params = "code")
	public ResponseEntity<List<FurniturePieceDTO>> findByCodeContains(@RequestParam String code){
		List<FurniturePiece> pieces = furniturePieceService.findByCodeContains(code);
		List<FurniturePieceDTO> retVal = convertListToDTO(pieces);
		if(retVal.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FurniturePieceDTO>>(retVal, HttpStatus.OK);
	}
	@GetMapping(value = "/api/furniture", params = {"greaterThan","lessThan"})
	public ResponseEntity<List<FurniturePieceDTO>> findByPrice(@RequestParam Integer greaterThan, Integer lessThan) {
		List<FurniturePiece> pieces = furniturePieceService.findByPrice(greaterThan, lessThan);
		List<FurniturePieceDTO> retVal = convertListToDTO(pieces);
		if(retVal.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<FurniturePieceDTO>>(retVal, HttpStatus.OK);
	}
	
	
	private List<FurniturePieceDTO> convertListToDTO(List<FurniturePiece> pieces) {
		List<FurniturePieceDTO> retDTO = new ArrayList<>();
		for (FurniturePiece piece : pieces) {
			FurniturePieceDTO val = convertPieceToDTO(piece);
			retDTO.add(val);
		}
		return retDTO;
	}

	private FurniturePieceDTO convertPieceToDTO(FurniturePiece piece) {
		FurniturePieceDTO retVal = new FurniturePieceDTO(piece.getId(), piece.getName(), piece.getPrice(),
				piece.getCode(), piece.getFurnitureType());
		return retVal;
	}
}
