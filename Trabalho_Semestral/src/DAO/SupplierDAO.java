/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Connection.ConnectionMySQL;
import Model.Supplier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SupplierDAO {

    // Save supplier
    public void save(Supplier supplier) {
        String sql = "INSERT INTO fornecedor (nome, numerotelefone, estado) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getPhoneNumber());
            pst.setInt(3, supplier.getState());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    // Retrieve all suppliers
    public List<Supplier> findAll() {
        String sql = "SELECT * FROM fornecedor";
        List<Supplier> suppliers = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setId(rs.getInt("id"));
                supplier.setName(rs.getString("nome"));
                supplier.setPhoneNumber(rs.getString("numerotelefone"));
                supplier.setState(rs.getInt("estado"));
                supplier.setCreationDate(rs.getTimestamp("dataCriacao"));
                suppliers.add(supplier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    // Retrieve supplier by ID
    public Supplier findSupplierById(int id) throws SQLException {
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Supplier(rs.getInt("id"), rs.getString("nome"), rs.getString("numerotelefone"), rs.getInt("estado"), rs.getTimestamp("dataCriacao"));
            }
        }
        return null;
    }

    // Delete supplier by ID
    public void deleteSupplier(int id) throws SQLException {
        String sql = "DELETE FROM fornecedor WHERE id = ?";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    // Update supplier details
    public void updateSupplier(Supplier supplier) throws SQLException {
        String sql = "UPDATE fornecedor SET nome = ?, numerotelefone = ?, estado = ? WHERE id = ?";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, supplier.getName());
            pst.setString(2, supplier.getPhoneNumber());
            pst.setInt(3, supplier.getState());
            pst.setInt(4, supplier.getId());
            pst.executeUpdate();
        }
    }

    // Search suppliers by name
    public List<Supplier> searchSuppliersByName(String name) throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor WHERE nome LIKE ?";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                suppliers.add(new Supplier(rs.getInt("id"), rs.getString("nome"), rs.getString("numerotelefone"), rs.getInt("estado"), rs.getTimestamp("dataCriacao")));
            }
        }
        return suppliers;
    }

   
}
