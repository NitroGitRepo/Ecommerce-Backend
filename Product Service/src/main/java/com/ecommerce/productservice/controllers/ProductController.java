package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.commons.AuthenticationCommons;
import com.ecommerce.productservice.dtos.GetProductDto;
import com.ecommerce.productservice.dtos.Role;
import com.ecommerce.productservice.dtos.UserDto;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    //private static final Logger logger = (Logger) LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService ps;

    @Autowired
    private RestTemplate restTemplate;

    private AuthenticationCommons authenticationCommons;

    public ProductController(ProductService ps, AuthenticationCommons authenticationCommons){
        this.ps = ps;
        this.authenticationCommons = authenticationCommons;
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

    @GetMapping("/all/{token}")
    public ResponseEntity<List<GetProductDto>>  getAllProduct(@PathVariable("token") String token){
        System.out.println("Product Conteoller ******************"+token);
        UserDto userDto = authenticationCommons.validateToken(token);
        if(userDto == null) {
            //token is invalid
            return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
//        boolean isAdmin = false;
//        for(Role role : userDto.getRoles()){
//            if(role.equals("ADMIN")){
//                isAdmin  = true;
//                break;
//            }
//        }
//        if(!isAdmin){
//            return null;
//        }
         //return ps.getAllProduct(token);
        List<GetProductDto> products = ps.getAllProduct(token);
        return ResponseEntity.ok(products);
    }

    //@RequestMapping( path = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public String createProduct(@RequestBody Product product){
        System.out.println(product.getTitle());
        System.out.println(product.getCategory());
        System.out.println(product.getDescription());

        return "Product created "+product.getTitle();
    }

    @GetMapping("/check/check/statuscheck")
    public String checkStatus(){
        System.out.println("Status Check Controller");
        //RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject("http://localhost:9091/users/sample", Void.class);
        restTemplate.getForObject("http://USER-SERVICE/users/sample",Void.class);
        return "STATUS CHECKED SUCCESSFULLY";
    }

    @GetMapping("/loggenerate")
    public String loggingDemo(){

        System.out.println("LOG GENERATOR");
//        logger.info("INFO SEVERITY");
//        logger.warn("WARNING SEVERITY");
//        logger.error("ERROR SEVERITY");
//        logger.debug("DEBUG SEVERITY");
//        logger.trace("TRACE SEVERIOTY");
        log.info("INFO SEVERITY");
        log.warn("WARN SEVERITY");
        log.error("ERROR SEVERITY");

//        log.debug("DEBUG SEVERITY");
//        log.trace("TRACE SEVERITY");


        return "LOGS GENERATED";
    }


}
