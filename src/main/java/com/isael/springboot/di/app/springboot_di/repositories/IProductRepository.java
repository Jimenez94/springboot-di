package com.isael.springboot.di.app.springboot_di.repositories;

import com.isael.springboot.di.app.springboot_di.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> fineAll();
    Product findById(Long id);
}
