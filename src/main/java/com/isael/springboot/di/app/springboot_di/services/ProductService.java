package com.isael.springboot.di.app.springboot_di.services;

import com.isael.springboot.di.app.springboot_di.models.Product;
import com.isael.springboot.di.app.springboot_di.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductService implements IProductoService {
    // private ProductRepository repository = new ProductRepository();

    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> fineAll() {
        return repository.fineAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            //Product newProduct = new Product(p.getId(), p.getName(), priceImp.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product fineById(Long id) {
        return repository.findById(id);
    }
}
