package com.isael.springboot.di.app.springboot_di.controllers;

import com.isael.springboot.di.app.springboot_di.models.Product;
import com.isael.springboot.di.app.springboot_di.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {
    //private ProductService service = new ProductService();
    @Autowired
    private ProductService service;
    @GetMapping
    public List<Product> list(){
//        ProductService service = new ProductService();
        return service.fineAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable long  id){
  //      ProductService service = new ProductService();
        return service.fineById(id);
    }
}
