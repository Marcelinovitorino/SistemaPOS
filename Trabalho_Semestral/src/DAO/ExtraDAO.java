package DAO;

import Connection.ConnectionMySQL;
import Model.Extra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ExtraDAO {

    public void save(Extra extra) {
        String sql = "INSERT INTO extra (val) VALUES (?)";

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, extra.getVal());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public List<Extra> findAll() {
        String sql = "SELECT * FROM extra";
        List<Extra> extras = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Extra extra = new Extra();
                extra.setId(rs.getInt("id"));
                extra.setVal(rs.getString("val"));
                extras.add(extra);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extras;
    }

    public Extra findById(int id) throws SQLException {
        String sql = "SELECT * FROM extra WHERE id = ?";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Extra(rs.getInt("id"), rs.getString("val"));
            }
        }
        return null;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM extra WHERE id = ?";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public void update(Extra extra) throws SQLException {
        String sql = "UPDATE extra SET val = ? WHERE id = ?";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, extra.getVal());
            pst.setInt(2, extra.getId());
            pst.executeUpdate();
        }
    }

    public void updateVal(Extra extra) throws SQLException {
        String sql = "UPDATE extra SET val = ? WHERE id = 1";
        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, extra.getVal());
            pst.executeUpdate();
        }
    }
}
