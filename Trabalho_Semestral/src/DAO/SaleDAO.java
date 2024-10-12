package DAO;

import Connection.ConnectionMySQL;
import Model.Sale;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SaleDAO {

    public void save(Sale sale) {
        String sql = "INSERT INTO vendas (idFatura, idCiente, nomeCliente, quantidadeTotal, totalPago, Status, Troco) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setObject(1, sale.getIdFatura());
            pst.setObject(2, sale.getIdCliente());
            pst.setString(3, sale.getNomeCliente());
            pst.setInt(4, sale.getQuantidadeTotal());
            pst.setBigDecimal(5, sale.getTotalPago());
            pst.setString(6, sale.getStatus());
            pst.setBigDecimal(7, sale.getTroco());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public List<Sale> findAll() {
        String sql = "SELECT * FROM vendas";
        List<Sale> sales = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setId(rs.getInt("id"));
                sale.setIdFatura(rs.getObject("idFatura", Integer.class));
                sale.setIdCliente(rs.getObject("idCiente", Integer.class));
                sale.setNomeCliente(rs.getString("nomeCliente"));
                sale.setQuantidadeTotal(rs.getInt("quantidadeTotal"));
                sale.setTotalPago(rs.getBigDecimal("totalPago"));
                sale.setStatus(rs.getString("Status"));
                sale.setTroco(rs.getBigDecimal("Troco"));
                sales.add(sale);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sales;
    }

    public Sale findSaleById(int id) throws SQLException {
        String sql = "SELECT * FROM vendas WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Sale(
                        rs.getInt("id"),
                        rs.getObject("idFatura", Integer.class),
                        rs.getObject("idCiente", Integer.class),
                        rs.getString("nomeCliente"),
                        rs.getInt("quantidadeTotal"),
                        rs.getBigDecimal("totalPago"),
                        rs.getString("Status"),
                        rs.getBigDecimal("Troco")
                );
            }
        }
        return null;
    }

    public void deleteSale(int id) throws SQLException {
        String sql = "DELETE FROM vendas WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public void updateSale(Sale sale) throws SQLException {
        String sql = "UPDATE vendas SET idFatura = ?, idCiente = ?, nomeCliente = ?, quantidadeTotal = ?, totalPago = ?, Status = ?, Troco = ? WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setObject(1, sale.getIdFatura());
            pst.setObject(2, sale.getIdCliente());
            pst.setString(3, sale.getNomeCliente());
            pst.setInt(4, sale.getQuantidadeTotal());
            pst.setBigDecimal(5, sale.getTotalPago());
            pst.setString(6, sale.getStatus());
            pst.setBigDecimal(7, sale.getTroco());
            pst.setInt(8, sale.getId());
            pst.executeUpdate();
        }
    }

    public List<Sale> searchSalesByName(String nomeCliente) throws SQLException {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT * FROM vendas WHERE nomeCliente LIKE ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + nomeCliente + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sales.add(new Sale(
                        rs.getInt("id"),
                        rs.getObject("idFatura", Integer.class),
                        rs.getObject("idCiente", Integer.class),
                        rs.getString("nomeCliente"),
                        rs.getInt("quantidadeTotal"),
                        rs.getBigDecimal("totalPago"),
                        rs.getString("Status"),
                        rs.getBigDecimal("Troco")
                ));
            }
        }
        return sales;
    }
}
