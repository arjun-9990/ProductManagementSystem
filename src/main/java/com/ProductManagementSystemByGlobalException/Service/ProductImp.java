package com.ProductManagementSystemByGlobalException.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductManagementSystemByGlobalException.Exception.ProductNotFoundException;
import com.ProductManagementSystemByGlobalException.Repo.IServiceRepo;
import com.ProductManagementSystemByGlobalException.model.Product;

@Service
public class ProductImp implements IProductService {

	private IServiceRepo repo;

	@Autowired
	public void setRepo(IServiceRepo repo) {
		this.repo = repo;
	}

	@Override
	public Product saveProduct(Product product) {
		if (product.getId() == null)
			return repo.save(product);

		throw new ProductNotFoundException("Product alread exist");
	}

	@Override
	public List<Product> fetchAllProduct() {
		return repo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found by id" + id));
	}

	@Override
	public Product getProductsByName(String name) {
		if (repo.findByName(name) != null) {
			return repo.findByName(name);
		}
		throw new ProductNotFoundException("Product Not found for the Give Name :- " + name);
	}

	@Override
	public List<Product> getAvailableProducts(Integer quantity) {
		System.out.println(repo.findByQuantityGreaterThan(quantity));
		return repo.findByQuantityGreaterThan(quantity);
	}

	@Override
	public List<Product> saveMultipleProduct(List<Product> products) {
		return repo.saveAll(products);
	}

	@Override
	public Product updateProdct(Product product) {
		if (repo.findById(product.getId()) != null) {
			return repo.save(product);
		}
		throw new ProductNotFoundException("Product not exist");
	}

	@Override
	public Product updateProductQuantity(Integer id, Integer quantity) {
	    Optional<Product> optionalProduct = repo.findById(id);

	    if (optionalProduct.isPresent()) {
	        Product product = optionalProduct.get();
	        product.setQuantity(quantity);
	        return repo.save(product);
	    } else {
	        throw new ProductNotFoundException("Product not exist with id: " + id);
	    }
	}


	@Override
	public String deleteProductById(Integer id) {
		Optional<Product> productOpt = repo.findById(id);
		if (productOpt.isPresent()) {
			repo.deleteById(id);
			return "Product deleted successfully";
		}
		throw new ProductNotFoundException("Product with ID " + id + " does not exist");
	}

	@Override
	public String deleteProductsByBrand(String brand) {
	    List<Product> products = repo.findByBrand(brand);
	    if (products.isEmpty()) {
	        throw new ProductNotFoundException("No products found for brand: " + brand);
	    }
	    repo.deleteAllInBatch(products);
	    return "Products deleted successfully for brand: " + brand;
	}

}
