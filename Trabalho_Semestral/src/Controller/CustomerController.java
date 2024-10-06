package Controller;

import DAO.CustomerDAO;
import Model.Customer;
import java.util.List;

public class CustomerController {
    private CustomerDAO customerDAO;

    public CustomerController() {
        this.customerDAO = new CustomerDAO();
    }

    public void saveCustomer(String nome, String numeroTelefone) {
        Customer customer = new Customer();
        customer.setNome(nome);
        customer.setNumeroTelefone(numeroTelefone);
        customerDAO.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    // Métodos adicionais como update, delete, etc.
}
