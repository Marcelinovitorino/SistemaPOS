package Controller;

import DAO.CustomerDAO;
import Model.Customer;
import java.util.List;
import java.sql.SQLException;

public class CustomerController {
    private CustomerDAO customerDAO;

    public CustomerController() {
        this.customerDAO = new CustomerDAO();
    }

    public void saveCustomer(String nome, String numeroTelefone) {
        Customer customer = new Customer();
        customer.setNome(nome);
        customer.setNumeroTelefone(numeroTelefone);
        System.out.println(customer.toString());
        customerDAO.save(customer);
    }

    
    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }
    
     public Customer getCustomerById(int id) throws SQLException {
        return customerDAO.findCustomerById(id);
    }

    public void deleteCustomer(int id) throws SQLException {
        customerDAO.deleteCustomer(id);
    }

    public void updateCustomer(int id, String nome, String numero) throws SQLException {
        Customer customer = new Customer(id, nome, numero);
        customerDAO.updateCustomer(customer);
    }

    public List<Customer> searchCustomersByName(String name) throws SQLException {
        return customerDAO.searchCustomersByName(name);
    }

    // Métodos adicionais como update, delete, etc.
}
