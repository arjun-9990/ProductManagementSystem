package com.ProductManagementSystemByGlobalException.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ProductManagementSystemByGlobalException.model.Product;

@Repository
public interface IServiceRepo extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	List<Product> findByQuantityGreaterThan(Integer quantity);

	List<Product> findByBrand(String brand);
}
