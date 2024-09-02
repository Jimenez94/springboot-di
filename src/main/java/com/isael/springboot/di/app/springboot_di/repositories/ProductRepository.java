package com.isael.springboot.di.app.springboot_di.repositories;

import com.isael.springboot.di.app.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;


@Repository("muchosProductos")
@Primary
//@RequestScope //todo: esto es por si tenemos un objeto que sea mutado, solo lo llama y al haer otra llamada se desase la llamada anterior y no modifica el objeto
//@SessionScope //todo: eso son anotaciones que solo funciona en una secion (login)
public class ProductRepository implements IProductRepository {
    private List<Product> data;
    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "PC", 2500L),
                new Product(2L, "CPU intel Core i9", 2500L),
                new Product(3L, "Teclado Razar Mini 60%", 1800L),
                new Product(4L, "MotherBoard Gigabyte", 8900L));
    }

    @Override
    public List<Product> fineAll(){
        return  this.data;
    }

    @Override
    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
