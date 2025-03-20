package com.example.productservicefeb24.services;

import com.example.productservicefeb24.DTOs.CreateProductRequestDto;
import com.example.productservicefeb24.models.Product;

import java.util.List;


public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getProducts();

    Product createProduct(String title, String description, String category, double price, String image);

    //public List<Product> getAllProducts();
}
