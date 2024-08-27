package com.isael.springboot.di.app.springboot_di.services;

import com.isael.springboot.di.app.springboot_di.models.Product;

import java.util.List;

public interface IProductoService {
    List<Product> fineAll();
    Product fineById(Long id);
}
