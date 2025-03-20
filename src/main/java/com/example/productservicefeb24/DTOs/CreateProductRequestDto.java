package com.example.productservicefeb24.DTOs;

//DTOs for each request(get, post, delete...) is better coz in future if req need additional params,
// you can add without impacting anything else

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    //private Long id; //can't give ID for product not yet created
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;
}
