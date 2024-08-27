package com.isael.springboot.di.app.springboot_di.services;

import com.isael.springboot.di.app.springboot_di.models.Product;
import com.isael.springboot.di.app.springboot_di.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductoService {

    @Autowired
    //@Qualifier("productRepositoryFoo")
    //@Qualifier("muchosProductos")
    private IProductRepository repository;
    public List<Product> fineAll() {
        return repository.fineAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }
    public Product fineById(Long id) {
        return repository.findById(id);
    }
}
