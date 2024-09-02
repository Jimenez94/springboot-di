package com.isael.springboot.di.app.springboot_di.repositories;

import com.isael.springboot.di.app.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;


//@Primary
@Repository
public class ProductRepositoryFoo implements IProductRepository{
    @Override
    public List<Product> fineAll() {
        return Collections.singletonList(new Product(1L,"Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id,"Monitor Asus 27", 600L);
    }
}
