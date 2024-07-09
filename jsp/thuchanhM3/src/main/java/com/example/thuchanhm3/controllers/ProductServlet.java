package com.example.thuchanhm3.controllers;

import com.example.thuchanhm3.models.Category;
import com.example.thuchanhm3.models.Product;
import com.example.thuchanhm3.models.ProductDTO;
import com.example.thuchanhm3.services.category.CategoryService;
import com.example.thuchanhm3.services.category.ICategoryService;
import com.example.thuchanhm3.services.product.IProductService;
import com.example.thuchanhm3.services.product.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name="ProductServlet", urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {
    private static IProductService productService = new ProductService();
    private static ICategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/list":
                selectAllProduct(req,resp);

                break;
            case "/create":
                showFormCreate(req,resp);
                break;
            case "/delete":
                deleteProduct(req,resp);
                break;
            case "/search":
                searchProductByName(req,resp);
                break;
            case "/searchByCategory":
                searchProductByCategory(req,resp);
                break;
        }
    }

    private void searchProductByCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.selectAllCategory();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/list.jsp").forward(req,resp);
    }

    private void searchProductByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<ProductDTO> products = productService.searchProductByName(keyword);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/list.jsp").forward(req,resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        resp.sendRedirect("/products/list");
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.selectAllCategory();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/create.jsp").forward(req,resp);
    }

    private void selectAllProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductDTO> products = productService.selectAllProduct();
        req.setAttribute("products",products);
        req.getRequestDispatcher("/views/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                createProduct(req,resp);
                break;
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String sku = req.getParameter("sku");
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        String errorMessage = validateProduct(sku, name,priceStr);

        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            errorMessage = "Vui lòng nhập giá.";
        }
        String unit = req.getParameter("unit");
        Date day_th = Date.valueOf(req.getParameter("day_th"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Product product = new Product();
        product.setSku(sku);
        product.setName(name);
        product.setUnit(unit);
        product.setPrice(price);
        product.setDay_th(day_th);
        product.setCategoryId(categoryId);
        if (errorMessage != null) {
            List<Category> categories = categoryService.selectAllCategory();
            req.setAttribute("categories", categories);
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("product", product);
            req.getRequestDispatcher("/views/create.jsp").forward(req, resp);
            return;
        }
        productService.createProduct(product);
        if (product.getErrors().isEmpty()) {
            req.setAttribute("noti", "Thêm thành công!");
            selectAllProduct(req, resp);
        } else {
            List<Category> categories = categoryService.selectAllCategory();
            req.setAttribute("categories", categories);
            req.setAttribute("product", product);
            resp.sendRedirect("/products/list");
        }
        req.setAttribute("product", product);
        resp.sendRedirect("/products/list");
    }


    private String validateProduct(String sku ,String name, String priceStr) {
        if (sku == null || sku.isEmpty()) {
            return "Không được để trống mã sản phẩm";
        }
        if (name == null || name.isEmpty()) {
            return "Không được để trống tên sản phẩm";
        }
        try {
            if (priceStr == null || priceStr.isEmpty()) {
                return "Không được để trống giá";
            }
            double price = Double.parseDouble(priceStr);
            if (price < 1000) {
                return "Giá phải lớn hơn 1000";
            }
        } catch (NumberFormatException e) {
            return "Vui lòng nhập đúng giá";
        }
        return null;
    }

}
