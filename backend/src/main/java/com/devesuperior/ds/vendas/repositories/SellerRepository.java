package com.devesuperior.ds.vendas.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.devesuperior.ds.vendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
