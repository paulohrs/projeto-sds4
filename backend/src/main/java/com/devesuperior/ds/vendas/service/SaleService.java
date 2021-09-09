package com.devesuperior.ds.vendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devesuperior.ds.vendas.dto.SaleDTO;
import com.devesuperior.ds.vendas.dto.SaleSuccessDTO;
import com.devesuperior.ds.vendas.dto.SaleSumDTO;
import com.devesuperior.ds.vendas.entities.Sale;
import com.devesuperior.ds.vendas.repositories.SaleRepository;
import com.devesuperior.ds.vendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGoupeBySeller(){
		return repository.amountGoupeBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGoupeBySeller(){
		return repository.successGoupeBySeller();
	}
}
