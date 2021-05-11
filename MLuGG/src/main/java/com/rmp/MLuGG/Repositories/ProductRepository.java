package com.rmp.MLuGG.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rmp.MLuGG.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	Product findByProduct(String product);
}
