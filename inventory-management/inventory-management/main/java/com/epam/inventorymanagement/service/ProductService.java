package com.epam.inventorymanagement.service;

import com.epam.inventorymanagement.model.Product;
import com.epam.inventorymanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long productId, Product updatedProduct) {
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new IllegalArgumentException("Product not found"));

		existingProduct.setName(updatedProduct.getName());
		existingProduct.setDescription(updatedProduct.getDescription());
		existingProduct.setPrice(updatedProduct.getPrice());
		existingProduct.setQuantity(updatedProduct.getQuantity());


		return productRepository.save(existingProduct);
	}

}