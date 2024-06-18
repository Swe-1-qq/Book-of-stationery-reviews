package com.swe1qq.stationery.ServiceLayer;

import com.swe1qq.stationery.DataAccessLayer.DAO.ProductDAO;
import com.swe1qq.stationery.DataAccessLayer.Entity.Product;
import java.util.List;

/**
 * Сервісний клас для роботи з продуктами.
 */
public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * Додає новий продукт.
     *
     * @param product Об'єкт продукту для додавання.
     */
    public void createProduct(Product product) {
        productDAO.createProduct(product);
    }

    /**
     * Повертає список усіх продуктів.
     *
     * @return Список продуктів.
     */
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }
}
