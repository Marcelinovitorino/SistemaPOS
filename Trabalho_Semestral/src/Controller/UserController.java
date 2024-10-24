/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import java.sql.SQLException;
import java.util.List;
import org.json.JSONObject;

public class UserController {

    private UserDAO userDAO;

   
    public UserController() {
        this.userDAO = new UserDAO();
    }

 
    public void addUser(String nome, String funcionario, String perfil, String username, String senha, int estado) {
        User user = new User();
        user.setNome(nome);
        user.setFuncionario(funcionario);
        user.setPerfil(perfil);
        user.setUsername(username);
        user.setSenha(senha);
        user.setEstado(estado);

        userDAO.save(user);
    }

    
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    
    public User getUserById(int id) {
        try {
            return userDAO.findUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByEmail(String email) {
        try {
            return userDAO.findUserByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public User getUserByUsername(String username) {
        try {
            return userDAO.findUserByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

 
    public void updateUser(int id, String nome, String funcionario, String perfil, String username, String senha, int estado) {
        try {
            User user = new User();
            user.setId(id);
            user.setNome(nome);
            user.setFuncionario(funcionario );
            user.setPerfil(perfil);
            user.setUsername(username);
            user.setSenha(senha);
            user.setEstado(estado);

            userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void deleteUser(int id) {
        try {
            userDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  
    public List<User> searchUsersByName(String nome) {
        try {
            return userDAO.searchUsersByName(nome);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String validateLogin(String email, String password) throws SQLException {
        User user = userDAO.findUserByEmail(email);

        if (user != null && user.getSenha().equals(password)) {
            return user.getPerfil(); 
        } else {
            return null; 
        }
    }
    
    
}
