package com.devesuperior.ds.vendas.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesuperior.ds.vendas.dto.SaleDTO;
import com.devesuperior.ds.vendas.dto.SaleSuccessDTO;
import com.devesuperior.ds.vendas.dto.SaleSumDTO;
import com.devesuperior.ds.vendas.service.SaleService;

@RestController
@RequestMapping(value= "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGoupeBySeller(){
		List<SaleSumDTO> list = service.amountGoupeBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGoupeBySeller(){
		List<SaleSuccessDTO> list = service.successGoupeBySeller();
		return ResponseEntity.ok(list);
	}
}


