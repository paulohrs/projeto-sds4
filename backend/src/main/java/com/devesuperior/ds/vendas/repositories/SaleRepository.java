package com.devesuperior.ds.vendas.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuperior.ds.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}