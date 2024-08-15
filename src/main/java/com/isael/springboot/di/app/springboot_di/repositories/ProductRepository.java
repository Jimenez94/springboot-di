package com.isael.springboot.di.app.springboot_di.repositories;

import com.isael.springboot.di.app.springboot_di.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    private List<Product> data;
    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "PC", 2500L),
                new Product(2L, "CPU intel Core i9", 2500L),
                new Product(3L, "Teclado Razar Mini 60%", 1800L),
                new Product(4L, "MotherBoard Gigabyte", 8900L));
    }
    public List<Product> fineAll(){
        return  this.data;
    }

    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
