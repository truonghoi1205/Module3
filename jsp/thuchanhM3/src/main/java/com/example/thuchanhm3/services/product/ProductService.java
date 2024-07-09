package com.example.thuchanhm3.services.product;

import com.example.thuchanhm3.models.Product;
import com.example.thuchanhm3.models.ProductDTO;
import com.example.thuchanhm3.repositories.product.IProductRepo;
import com.example.thuchanhm3.repositories.product.ProductRepo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductService implements IProductService {
    private static IProductRepo productRepo = new ProductRepo();
    @Override
    public List<ProductDTO> selectAllProduct() {
        try {
            return productRepo.selectAllProduct();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createProduct(Product product) {
        try {
            productRepo.createProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        try {
            productRepo.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductDTO> searchProductByName(String keyword) {
        try {
            return productRepo.searchProductByName(keyword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> searchProductByCategory(int categoryId) {
        try {
            return productRepo.searchProductByCategory(categoryId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
