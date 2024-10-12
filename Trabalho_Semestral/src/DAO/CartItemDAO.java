package DAO;

import Connection.ConnectionMySQL;
import Model.CartItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CartItemDAO {

    public void save(CartItem cartItem) {
        String sql = "INSERT INTO carinho (idFatura, nomeProduto, idProduto, quantidade, precoUnit, precoTotal) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, cartItem.getIdFatura());
            pst.setString(2, cartItem.getNomeProduto());
            pst.setString(3, cartItem.getIdProduto());
            pst.setString(4, cartItem.getQuantidade());
            pst.setString(5, cartItem.getPrecoUnit());
            pst.setString(6, cartItem.getPrecoTotal());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public List<CartItem> findAll() {
        String sql = "SELECT * FROM carinho";
        List<CartItem> cartItems = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getInt("ID"));
                cartItem.setIdFatura(rs.getInt("idFatura"));
                cartItem.setNomeProduto(rs.getString("nomeProduto"));
                cartItem.setIdProduto(rs.getString("idProduto"));
                cartItem.setQuantidade(rs.getString("quantidade"));
                cartItem.setPrecoUnit(rs.getString("precoUnit"));
                cartItem.setPrecoTotal(rs.getString("precoTotal"));
                cartItems.add(cartItem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }

    public CartItem findById(int id) throws SQLException {
        String sql = "SELECT * FROM carinho WHERE ID = ?";
        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new CartItem(rs.getInt("ID"), rs.getInt("idFatura"), rs.getString("nomeProduto"),
                                    rs.getString("idProduto"), rs.getString("quantidade"), 
                                    rs.getString("precoUnit"), rs.getString("precoTotal"));
            }
        }
        return null;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM carinho WHERE ID = ?";
        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public void update(CartItem cartItem) throws SQLException {
        String sql = "UPDATE carinho SET idFatura = ?, nomeProduto = ?, idProduto = ?, quantidade = ?, precoUnit = ?, precoTotal = ? WHERE ID = ?";
        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, cartItem.getIdFatura());
            pst.setString(2, cartItem.getNomeProduto());
            pst.setString(3, cartItem.getIdProduto());
            pst.setString(4, cartItem.getQuantidade());
            pst.setString(5, cartItem.getPrecoUnit());
            pst.setString(6, cartItem.getPrecoTotal());
            pst.setInt(7, cartItem.getId());
            pst.executeUpdate();
        }
    }

   
}
