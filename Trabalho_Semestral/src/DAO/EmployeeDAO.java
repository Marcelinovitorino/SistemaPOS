package DAO;

import Connection.ConnectionMySQL;
import Model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmployeeDAO {

    public void save(Employee employee) {
        String sql = "INSERT INTO funcionario (nome, numerotelefone) VALUES (?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, employee.getNome());
            pst.setString(2, employee.getNumeroTelefone());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM funcionario";
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setNome(rs.getString("nome"));
                employee.setNumeroTelefone(rs.getString("numerotelefone"));
               
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee findEmployeeById(long id) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getLong("id"), rs.getString("nome"), rs.getString("numerotelefone"));
            }
        }
        return null;
    }

    public void deleteEmployee(long id) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setLong(1, id);
            pst.executeUpdate();
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, numerotelefone = ? WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, employee.getNome());
            pst.setString(2, employee.getNumeroTelefone());
            pst.setLong(3, employee.getId());
            pst.executeUpdate();
        }
    }

    public List<Employee> searchEmployeesByName(String name) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM funcionario WHERE nome LIKE ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                employees.add(new Employee(rs.getLong("id"), rs.getString("nome"), rs.getString("numerotelefone")));
            }
        }
        return employees;
    }
}
