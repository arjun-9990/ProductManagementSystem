package com.ProductManagementSystemByGlobalException.Service;

import java.util.List;

import com.ProductManagementSystemByGlobalException.model.Product;

public interface IProductService {
	
	public Product saveProduct(Product product);

	public List<Product> fetchAllProduct();

	public Product getProductById(Integer id);

	public Product getProductsByName(String name);

	public List<Product> getAvailableProducts(Integer quantity);

	public List<Product> saveMultipleProduct(List<Product> products);

	public Product updateProdct(Product product);

	Product updateProductQuantity(Integer id, Integer quantity);

	public String deleteProductById(Integer id);

	String deleteProductsByBrand(String brand);

}
