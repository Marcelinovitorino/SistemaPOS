package Controller;

import DAO.ProductDAO;
import Model.Product;
import java.sql.SQLException;
import java.util.List;

public class ProductController {
    private final ProductDAO productDAO;

    public ProductController() {
        productDAO = new ProductDAO();
    }

    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductById(int id) throws SQLException {
        return productDAO.findProductById(id);
    }

    public void deleteProduct(int id) throws SQLException {
        productDAO.deleteProduct(id);
    }

    public void updateProduct(Product product) throws SQLException {
        productDAO.updateProduct(product);
    }

    public List<Product> searchProductsByName(String name) throws SQLException {
        return productDAO.searchProductsByName(name);
    }

    public Product getProductByName(String name) throws SQLException {
         return productDAO.findByName(name); }
}
