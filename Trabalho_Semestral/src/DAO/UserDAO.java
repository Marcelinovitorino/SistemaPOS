/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connection.ConnectionMySQL;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDAO {

    // Método para salvar um novo usuário no banco de dados
    public void save(User user) {
        String sql = "INSERT INTO usuario (nome, funcionario, perfil, username, senha, estado) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, user.getNome());
            pst.setString(2, user.getFuncionario());
            pst.setString(3, user.getPerfil());
            pst.setString(4, user.getUsername());
            pst.setString(5, user.getSenha());
            pst.setInt(6, user.getEstado());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    // Método para retornar todos os usuários
    public List<User> findAll() {
        String sql = "SELECT * FROM usuario";
        List<User> users = new ArrayList<>();

        try (Connection conn = ConnectionMySQL.getConnection(); PreparedStatement pst = conn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setFuncionario(rs.getString("funcionario"));
                user.setPerfil(rs.getString("perfil"));
                user.setUsername(rs.getString("username"));
                user.setSenha(rs.getString("senha"));
                user.setEstado(rs.getInt("estado"));
                user.setDataCriacao(rs.getTimestamp("dataCriacao"));
                users.add(user);
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Método para buscar um usuário por ID
    public User findUserById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("funcionario"),
                        rs.getString("perfil"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getInt("estado"),
                        rs.getTimestamp("dataCriacao")
                );
            }
        }
        return null;
    }

    public User findUserByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE username = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); 
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("funcionario"),
                        rs.getString("perfil"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getInt("estado"),
                        rs.getTimestamp("dataCriacao")
                );
            }
        }
        return null;
    }
    public User findUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); 
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("funcionario"),
                        rs.getString("perfil"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getInt("estado"),
                        rs.getTimestamp("dataCriacao")
                );
            }
        }
        return null;
    }

    // Método para deletar um usuário pelo ID
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    // Método para atualizar as informações de um usuário
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, funcionario = ?, perfil = ?, username = ?, senha = ?, estado = ? WHERE id = ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, user.getNome());
            pst.setString(2, user.getFuncionario());
            pst.setString(3, user.getPerfil());
            pst.setString(4, user.getUsername());
            pst.setString(5, user.getSenha());
            pst.setInt(6, user.getEstado());
            pst.setInt(7, user.getId());
            pst.executeUpdate();
        }
    }

    // Método para buscar usuários pelo nome
    public List<User> searchUsersByName(String name) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nome LIKE ?";
        try (Connection connection = ConnectionMySQL.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("funcionario"),
                        rs.getString("perfil"),
                        rs.getString("username"),
                        rs.getString("senha"),
                        rs.getInt("estado"),
                        rs.getTimestamp("dataCriacao")
                ));
            }
        }
        return users;
    }

}
