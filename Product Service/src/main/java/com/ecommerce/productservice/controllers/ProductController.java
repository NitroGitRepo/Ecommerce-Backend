package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService ps;

    public ProductController(ProductService ps){
        this.ps = ps;
    }

    @RequestMapping("/{id}")
    public  @ResponseBody GetProductDto getProductById(@PathVariable("id") int id) throws Exception
    {
        System.out.print("Get Product Id Controller");
        return ps.getProDuctById(id);
    }

    @RequestMapping("/{id}/{productname}")
    public String getProductByIdName(@PathVariable("id") long id, @PathVariable("productname") String name){
        return "Product "+id+" "+ name;
    }

    @GetMapping("")
    public @ResponseBody List<GetProductDto> getAllProduct(){
         return ps.getAllProduct();
    }

    //@RequestMapping( path = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public String createProduct(@RequestBody Product product){
        System.out.println(product.getTitle());
        System.out.println(product.getCategory());
        System.out.println(product.getDescription());

        return "Product created "+product.getTitle();
    }



}
