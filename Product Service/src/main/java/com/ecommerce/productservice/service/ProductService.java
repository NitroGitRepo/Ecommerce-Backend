package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundException;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public GetProductDto getProDuctById(int id) throws Exception{

        System.out.println("Product Service");

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/"+id;
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println(product);

        if(product == null){
            throw new NotFoundException();
        }

       GetProductDto obj = new GetProductDto();
//       obj.setName("SONY TV");
//       obj.setPrice(2000);
//       obj.setImageUrl("www.facebook.com");
        obj.setName(product.getTitle());
        obj.setImageUrl(product.getImage());
        obj.setPrice(product.getPrice());
         return obj;
    }


    public List<GetProductDto> getAllProduct(){
       RestTemplate restTemplate = new RestTemplate();
       String url = "https://fakestoreapi.com/products/";
       Product[] products = restTemplate.getForObject(url, Product[].class);
       List<GetProductDto> al = new ArrayList<>();
        for(Product product: products){
             al.add(convertToDto(product));
        }
        return al;
    }

    public static GetProductDto convertToDto(Product product){
        GetProductDto obj = new GetProductDto();
        obj.setName(product.getTitle());
        obj.setImageUrl(product.getImage());
        obj.setPrice(product.getPrice());
        return obj;
    }
}
