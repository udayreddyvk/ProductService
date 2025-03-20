package com.example.productservicefeb24.controllers;


import com.example.productservicefeb24.DTOs.CreateProductRequestDto;
//import com.example.productservicefeb24.DTOs.ErrorDto;
//import com.example.productservicefeb24.exceptions.ProductNotFoundException;
import com.example.productservicefeb24.models.Product;
import com.example.productservicefeb24.services.FakeStoreProductService;
import com.example.productservicefeb24.services.ProductService;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    private RestTemplate restTemplate;

    public ProductController(ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    /*
    POST products
    request body
    {
       title:
       description:
       price:
     }
     */
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request) {
        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()
        );
    }

    //GET /products/1
    //GET /products/20354
    @GetMapping("/products/{id}")     //{id} ->path variable
    public Product getProductDetails(@PathVariable("id") Long productId) {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    public void updateProduct() {

    }


}
