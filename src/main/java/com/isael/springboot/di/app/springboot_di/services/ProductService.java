package com.isael.springboot.di.app.springboot_di.services;

import com.isael.springboot.di.app.springboot_di.models.Product;
import com.isael.springboot.di.app.springboot_di.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private ProductRepository repository = new ProductRepository();
    public List<Product> fineAll() {
        return repository.fineAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }
    public Product fineById(Long id) {
        return repository.findById(id);
    }
}
