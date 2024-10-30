package DAO;

import Connection.ConnectionMySQL;
import Model.Report;

import javax.swing.JOptionPane;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDAO {

    public Report getRelatorioCompleto() {
        String sql = "SELECT COUNT(*) AS totalVendas, " +
                     "SUM(quantidadeTotal) AS quantidadeTotal, " +
                     "SUM(totalPago) AS receitaTotal, " +
                     "SUM(totalPago) - SUM(custoTotal) AS lucroTotal, " +
                     "CASE WHEN SUM(totalPago) = 0 THEN 0 ELSE (SUM(totalPago) - SUM(custoTotal)) / SUM(totalPago) END AS margemLucro " +
                     "FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int totalVendas = rs.getInt("totalVendas");
                int quantidadeTotal = rs.getInt("quantidadeTotal");
                BigDecimal receitaTotal = rs.getBigDecimal("receitaTotal");
                BigDecimal margemLucro = rs.getBigDecimal("margemLucro");

                return new Report(0, totalVendas, quantidadeTotal, receitaTotal, margemLucro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public int getTotalVendas() {
        String sql = "SELECT COUNT(*) AS totalVendas FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("totalVendas");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return 0;
    }

    public int getQuantidadeTotal() {
        String sql = "SELECT SUM(quantidadeTotal) AS quantidadeTotal FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantidadeTotal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return 0;
    }

    public BigDecimal getReceitaTotal() {
        String sql = "SELECT SUM(totalPago) AS receitaTotal FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal("receitaTotal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getMargemLucro() {
        String sql = "SELECT CASE WHEN SUM(totalPago) = 0 THEN 0 ELSE (SUM(totalPago) - SUM(custoTotal)) / SUM(totalPago) END AS margemLucro FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getBigDecimal("margemLucro");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }
}
