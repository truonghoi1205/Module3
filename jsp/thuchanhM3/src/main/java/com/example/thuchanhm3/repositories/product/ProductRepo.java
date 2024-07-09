package com.example.thuchanhm3.repositories.product;

import com.example.thuchanhm3.database.ConnectDB;
import com.example.thuchanhm3.models.Product;
import com.example.thuchanhm3.models.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepo implements IProductRepo {
    @Override
    public List<ProductDTO> selectAllProduct() throws SQLException {
       List<ProductDTO> products = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select p.*,c.name as category_name " +
                "from products p " +
                "join categories c " +
                "on p.category_id = c.id";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ProductDTO product = new ProductDTO();
            product.setId(rs.getInt("id"));
            product.setSku(rs.getString("sku"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setUnit(rs.getString("don_vi"));
            product.setCategoryName(rs.getString("category_name"));
            product.setDay_th(rs.getDate("day_th"));
            products.add(product);
        }
        return products;
    }

    @Override
    public void createProduct(Product product) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into products(sku,name,price,don_vi,day_th,category_id) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getSku());
        ps.setString(2, product.getName());
        ps.setDouble(3, product.getPrice());
        ps.setString(4, product.getUnit());
        ps.setDate(5,product.getDay_th());
        ps.setInt(6, product.getCategoryId());
        ps.executeUpdate();
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from products where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public List<ProductDTO> searchProductByName(String keyword) throws SQLException {
        List<ProductDTO> products = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select p.*, c.name as category_name from products p \n" +
                "join categories c \n" +
                "on c.id = p.category_id \n" +
                "where p.name like ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ProductDTO product = new ProductDTO();
            product.setId(rs.getInt("id"));
            product.setSku(rs.getString("sku"));
            product.setName(rs.getString("name"));
            product.setUnit(rs.getString("don_vi"));
            product.setPrice(rs.getDouble("price"));
            product.setDay_th(rs.getDate("day_th"));
            product.setCategoryName(rs.getString("category_name"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> searchProductByCategory(int categoryId) throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from products where category_id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,categoryId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setSku(rs.getString("sku"));
            product.setName(rs.getString("name"));
            product.setUnit(rs.getString("don_vi"));
            product.setPrice(rs.getDouble("price"));
            product.setDay_th(rs.getDate("day_th"));
            product.setCategoryId(rs.getInt("category_id"));
            products.add(product);
        }
        return products;
    }
}
