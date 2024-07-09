package com.example.thuchanhm3.services.product;

import com.example.thuchanhm3.models.Product;
import com.example.thuchanhm3.models.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> selectAllProduct();

    void createProduct(Product product);

    void deleteProduct(int id);

    List<ProductDTO> searchProductByName(String keyword);

    List<Product> searchProductByCategory(int categoryId);
}
