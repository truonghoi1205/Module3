package com.example.thuchanhm3.repositories.product;

import com.example.thuchanhm3.models.Product;
import com.example.thuchanhm3.models.ProductDTO;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepo {
    List<ProductDTO> selectAllProduct()throws SQLException;

    void createProduct(Product product) throws SQLException;

    void deleteProduct(int id) throws SQLException;

    List<ProductDTO> searchProductByName(String keyword) throws SQLException;

    List<Product> searchProductByCategory(int categoryId) throws SQLException;
}
