package com.isael.springboot.di.app.springboot_di;

import com.isael.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.isael.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    @Bean("productJson")
    //@Primary
    public ProductRepositoryJson productRepositoryJson() {
        return new ProductRepositoryJson();
    }

}
