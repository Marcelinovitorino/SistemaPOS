package DAO;

import Connection.ConnectionMySQL;
import Model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CustomerDAO {

    public void save(Customer customer) {
        String sql = "INSERT INTO cliente (nome, numerotelefone) VALUES (?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, customer.getNome());
            pst.setString(2, customer.getNumeroTelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM cliente";
        List<Customer> customers = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setNome(rs.getString("nome"));
                customer.setNumeroTelefone(rs.getString("numeroTelefone"));
                customers.add(customer);
                System.out.println(customer);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    
        public Customer findCustomerById(int id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("nome"), rs.getString("numerotelefone"));
            }
        }
        return null;
    }

    public void deleteCustomer(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, numerotelefone = ? WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, customer.getNome());
            pst.setString(2, customer.getNumeroTelefone());
            pst.setInt(3, customer.getId());
            pst.executeUpdate();
        }
    }

    public List<Customer> searchCustomersByName(String name) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        try (Connection connection = ConnectionMySQL.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("nome"), rs.getString("numerotelefone")));
            }
        }
        return customers;
    }

    // Outros métodos: update, delete, findById etc.
}
