package com.fabtec.apiproductregistration.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fabtec.apiproductregistration.enums.ProductCategory;
import com.fabtec.apiproductregistration.enums.ProductType;
import com.fabtec.apiproductregistration.modal.Product;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByProductName(String productName, Pageable pageable);
	Page<Product> findByBrand(String brand, Pageable pageable);
	Page<Product> findByCategory(Integer category, Pageable pageable);
	Page<Product> findByType(Integer type, Pageable pageable);
	
	@Modifying
	@Transactional
	@Query("UPDATE Product p SET p.productName = :productName, p.category = :category, p.brand = :brand,"
			+ " p.type = :type, p.cost = :cost, p.inventory = : inventory, p.updateDate = :updateDate"
			+ " WHERE p.id = :id")
	void update(@Param("namproductName") String productName, @Param("category") Integer category, 
			@Param("brand") String brand, @Param("type") Integer type, @Param("cost") double cost,
			@Param("inventory") double inventory, @Param("updateDate") LocalDateTime updateDate, 
			@Param("id") Long id);
	
}
