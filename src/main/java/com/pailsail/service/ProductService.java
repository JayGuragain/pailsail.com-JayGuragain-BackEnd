package com.pailsail.service;

import com.pailsail.model.Product;
import com.pailsail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> findProductsByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

	public Product updateProduct(Long id, Product productDetails) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Product> saveAllProducts(List<Product> products) {
	    List<Product> savedProducts = productRepository.saveAll(products);
	    savedProducts.forEach(product -> {
	        System.out.println("Saved Product: " + product.toString());
	    });
	    return savedProducts;
	}



	public void deleteAllProducts() {
		productRepository.deleteAll();
		
	}
	
	
}
