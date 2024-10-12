package DAO;

import Connection.ConnectionMySQL;
import Model.Product;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductDAO {

    public void save(Product product) {
        String sql = "INSERT INTO produtos (Nome, Marca, Preco, Quantidade, IDFornecedor, Lote) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, product.getNome());
            pst.setString(2, product.getMarca());
            pst.setBigDecimal(3, product.getPreco());
            pst.setInt(4, product.getQuantidade());
            pst.setInt(5, product.getIdFornecedor());
            pst.setString(6, product.getLote());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public List<Product> findAll() {
        String sql = "SELECT * FROM produtos";
        List<Product> products = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("ID"));
                product.setNome(rs.getString("Nome"));
                product.setMarca(rs.getString("Marca"));
                product.setPreco(rs.getBigDecimal("Preco"));
                product.setQuantidade(rs.getInt("Quantidade"));
                product.setIdFornecedor(rs.getInt("IDFornecedor"));
                product.setLote(rs.getString("Lote"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product findProductById(int id) throws SQLException {
        String sql = "SELECT * FROM produtos WHERE ID = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("ID"), rs.getString("Nome"), rs.getString("Marca"), rs.getBigDecimal("Preco"), rs.getInt("Quantidade"), rs.getInt("IDFornecedor"), rs.getString("Lote"));
            }
        }
        return null;
    }

    public void deleteProduct(int id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE ID = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE produtos SET Nome = ?, Marca = ?, Preco = ?, Quantidade = ?, IDFornecedor = ?, Lote = ? WHERE ID = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, product.getNome());
            pst.setString(2, product.getMarca());
            pst.setBigDecimal(3, product.getPreco());
            pst.setInt(4, product.getQuantidade());
            pst.setInt(5, product.getIdFornecedor());
            pst.setString(6, product.getLote());
            pst.setInt(7, product.getId());
            pst.executeUpdate();
        }
    }

    public List<Product> searchProductsByName(String name) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE Nome LIKE ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("ID"), rs.getString("Nome"), rs.getString("Marca"), rs.getBigDecimal("Preco"), rs.getInt("Quantidade"), rs.getInt("IDFornecedor"), rs.getString("Lote")));
            }
        }
        return products;
    }
}
