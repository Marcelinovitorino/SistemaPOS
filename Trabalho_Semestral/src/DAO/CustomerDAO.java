package DAO;

import Conection.ConnectionMySQL;
import Model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void save(Customer customer) {
        String sql = "INSERT INTO cliente (nome, numerotelefone) VALUES (?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, customer.getNome());
            pst.setString(2, customer.getNumeroTelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
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
                customer.setNumeroTelefone(rs.getString("numerotelefone"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // Outros métodos: update, delete, findById etc.
}
