package com.ProductManagementSystemByGlobalException.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductManagementSystemByGlobalException.Service.ProductImp;
import com.ProductManagementSystemByGlobalException.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

//	POST    /products                   → saveProduct
//	GET     /products                   → fetchAllProduct
//	GET     /products/{id}              → getProductById
//	GET     /products/name/{name}       → getProductsByName
//	GET     /products/available         → getAvailableProducts
//	POST    /products/batch             → saveMultipleProduct
//	PUT     /products                   → updateProduct
//	PATCH   /products/{id}/quantity     → updateProductQuantity
//	DELETE  /products/{id}              → deleteProductById
//	DELETE  /products/brand/{brand}     → deleteProductsByBrand

	private ProductImp repo;

	@Autowired
	public void setRepo(ProductImp repo) {
		this.repo = repo;
	}

	@GetMapping
	public ResponseEntity<List<Product>> fetchAllProduct() {
		return new ResponseEntity<List<Product>>(repo.fetchAllProduct(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(repo.saveProduct(product), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
		return new ResponseEntity<Product>(repo.getProductById(id), HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Product> getProductsByName(@PathVariable String name) {
		return new ResponseEntity<Product>(repo.getProductsByName(name), HttpStatus.OK);
	}

	@GetMapping("/available/{quantity}")
	public ResponseEntity<List<Product>> getAvailableProducts(Integer quantity) {
		return new ResponseEntity<List<Product>>(repo.getAvailableProducts(quantity), HttpStatus.OK);
	}

	@PostMapping("/batch")
	public ResponseEntity<String> saveMultipleProduct(@RequestBody List<Product> prouList) {
		List<Product> productLists = repo.saveMultipleProduct(prouList);
		return new ResponseEntity<String>("Data added successfully", HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		Product pdt = repo.updateProdct(product);
		return new ResponseEntity<String>("Updated successfully", HttpStatus.OK);
	}

	@PatchMapping("/{id}/{quantity}")
	public ResponseEntity<String> updateProductQuantity(@PathVariable Integer id, @PathVariable Integer quantity) {
		Product isUpdated = repo.updateProductQuantity(id, quantity);
		return new ResponseEntity<String>("Updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Integer id) {
		String product = repo.deleteProductById(id);
		return new ResponseEntity<String>(product, HttpStatus.OK);
	}

	@DeleteMapping("/brand/{brand}")
	public ResponseEntity<String> deleteProductsByBrand(@PathVariable String brand){
		String isDeleted = repo.deleteProductsByBrand(brand);
		return new ResponseEntity<String>(isDeleted ,HttpStatus.OK);
	}

}
