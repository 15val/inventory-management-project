package com.epam.inventorymanagement.controller;

import com.epam.inventorymanagement.service.ProductService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    /*@Test
    void testGetAllProducts() throws Exception {
        // Arrange
        Mockito.when(productService.getAllProducts()).thenReturn(Arrays.asList(
                new Product(1L, "Product 1", 20, 50, "Description 1"),
                new Product(2L, "Product 2", 30, 40, "Description 2")
        ));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Product 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Description 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Product 2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].description").value("Description 2"));
    }

    @Test
    void testAddProduct() throws Exception {
        // Arrange
        Product newProduct = new Product(null, "New Product", 25, 30, "New Description");
        Mockito.when(productService.addProduct(any(Product.class))).thenReturn(newProduct);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"New Product\",\"price\":25,\"quantity\":30,\"description\":\"New Description\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("New Product"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("New Description"));
    }*/

    /*@Test
    void testUpdateProduct() throws Exception {
        // Arrange
        Long productId = 1L;
        Product updatedProduct = new Product(productId, "Updated Product", 35, 60, "Updated Description");
        Mockito.when(productService.updateProduct(eq(productId), any(Product.class))).thenReturn(updatedProduct);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/products/{productId}", productId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Updated Product\",\"price\":35,\"quantity\":60,\"description\":\"Updated Description\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Updated Product"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Updated Description"));
    }*/
}