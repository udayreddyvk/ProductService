package com.example.productservicefeb24.services;

import com.example.productservicefeb24.DTOs.FakeStoreProductDto;
import com.example.productservicefeb24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    //RestTemplate
    // -allows to send http requests to external URLs and work with responses

    private RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        return fakeStoreProductDto.toProduct();
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 String category,
                                 double price,
                                 String image) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", // url
                fakeStoreProductDto, // request body
                FakeStoreProductDto.class // data type of response
        );

        if (response == null) return new Product();
        return response.toProduct();
    }
}
