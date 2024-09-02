package com.isael.springboot.di.app.springboot_di.services;

import com.isael.springboot.di.app.springboot_di.models.Product;
import com.isael.springboot.di.app.springboot_di.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductoService {

    @Autowired
    private Environment environment;
    @Autowired
    //@Qualifier("productRepositoryFoo")
    //@Qualifier("muchosProductos")
    //@Qualifier("productRepositoryJson")
    @Qualifier("productJson")
    private IProductRepository repository;
    public List<Product> fineAll() {
        return repository.fineAll().stream().map(p -> {
            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax",Double.class);
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
            /*p.setPrice(priceTax.longValue());
            return p;*/
            //todo: esto manda un objeto mutado, por cada peticion pero al agregar el @RequestScope en el Repository funciona como si fuera un objeto inmuado, ya que solo es por peticion

        }).collect(Collectors.toList());
    }
    public Product fineById(Long id) {
        return repository.findById(id);
    }
}
