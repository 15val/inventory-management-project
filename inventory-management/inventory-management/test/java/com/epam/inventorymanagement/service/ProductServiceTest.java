package com.epam.inventorymanagement.service;

import com.epam.inventorymanagement.model.Product;
import com.epam.inventorymanagement.repository.ProductRepository;
import com.epam.inventorymanagement.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	@Test
	void getAllProducts_shouldReturnListOfProducts() {
		// Arrange
		when(productRepository.findAll()).thenReturn(Collections.singletonList(new Product()));

		// Act
		var result = productService.getAllProducts();

		// Assert
		assertEquals(1, result.size());
	}

	@Test
	void testAddProduct() {
		// Arrange
		Product newProduct = new Product();
		newProduct.setName("New Product");
		newProduct.setPrice(20);
		newProduct.setQuantity(100);

		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(newProduct);

		// Act
		Product addedProduct = productService.addProduct(newProduct);

		// Assert
		assertEquals(newProduct.getName(), addedProduct.getName());
		assertEquals(newProduct.getPrice(), addedProduct.getPrice());
		assertEquals(newProduct.getQuantity(), addedProduct.getQuantity());
	}

	@Test
	void testUpdateProduct() {
		// Arrange
		Long productId = 1L;

		Product existingProduct = new Product();
		existingProduct.setId(productId);
		existingProduct.setName("Existing Product");
		existingProduct.setPrice(30);
		existingProduct.setQuantity(50);

		Product updatedProduct = new Product();
		updatedProduct.setName("Updated Product");
		updatedProduct.setPrice(40);
		updatedProduct.setQuantity(60);

		Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
		Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(updatedProduct);

		// Act
		Product result = productService.updateProduct(productId, updatedProduct);

		// Assert
		assertEquals(updatedProduct.getName(), result.getName());
		assertEquals(updatedProduct.getPrice(), result.getPrice());
		assertEquals(updatedProduct.getQuantity(), result.getQuantity());
	}
}