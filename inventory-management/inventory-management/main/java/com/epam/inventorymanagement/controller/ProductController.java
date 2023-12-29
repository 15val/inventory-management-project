package com.epam.inventorymanagement.controller;

import com.epam.inventorymanagement.model.Product;
import com.epam.inventorymanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product addedProduct = productService.addProduct(product);
		return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
	}

	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(
			@PathVariable Long productId,
			@RequestBody Product updatedProduct) {
		Product updated = productService.updateProduct(productId, updatedProduct);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
}