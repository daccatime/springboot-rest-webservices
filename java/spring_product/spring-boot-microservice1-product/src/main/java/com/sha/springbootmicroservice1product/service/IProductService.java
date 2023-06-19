package com.sha.springbootmicroservice1product.service;

import com.sha.springbootmicroservice1product.model.Product;
import java.util.List;

public interface IProductService {
    Product saveProduct(Product product);

    abstract void deleteProduct(Long productId);

    List<Product> findAllProducts();
}
