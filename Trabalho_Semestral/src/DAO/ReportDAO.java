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
        String sql = "SELECT COUNT(*) AS totalVendas, SUM(quantidade) AS quantidade, SUM(preco * quantidade) AS receitaTotal, " +
                     "SUM((preco * quantidade) - custoTotal) / SUM(preco * quantidade) AS margemLucro FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int totalVendas = rs.getInt("totalVendas");
                int quantidade = rs.getInt("quantidade");
                BigDecimal receitaTotal = rs.getBigDecimal("receitaTotal");
                BigDecimal margemLucro = rs.getBigDecimal("margemLucro");
                
                return new Report(0, totalVendas, quantidade, receitaTotal, margemLucro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return null;
    }

    public int getTotalVendas() {
        String sql = "SELECT COUNT(*) AS totalVendas FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
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
        String sql = "SELECT SUM(quantidade) AS quantidade FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantidade");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        return 0;
    }

    public BigDecimal getReceitaTotal() {
        String sql = "SELECT SUM(preco * quantidade) AS receitaTotal FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
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
        String sql = "SELECT SUM((preco * quantidade) - custoTotal) / SUM(preco * quantidade) AS margemLucro FROM vendas";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
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
