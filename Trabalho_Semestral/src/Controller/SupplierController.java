package Controller;

import DAO.SupplierDAO;
import Model.Supplier;
import java.sql.SQLException;
import java.util.List;

public class SupplierController {

    private SupplierDAO supplierDAO;

    // Constructor
    public SupplierController() {
        this.supplierDAO = new SupplierDAO();
    }

    // Create: Save a new supplier
    public void saveSupplier(String name, String phoneNumber, int state) {
        Supplier supplier = new Supplier();
        supplier.setName(name);
        supplier.setPhoneNumber(phoneNumber);
        supplier.setState(state);

        supplierDAO.save(supplier);
    }

    // Read: Find all suppliers
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.findAll();
    }

    // Read: Find a supplier by ID
    public Supplier getSupplierById(int id) {
        try {
            return supplierDAO.findSupplierById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update: Update an existing supplier
    public void updateSupplier(int id, String name, String phoneNumber, int state) {
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setName(name);
        supplier.setPhoneNumber(phoneNumber);
        supplier.setState(state);

        try {
            supplierDAO.updateSupplier(supplier);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete: Remove a supplier by ID
    public void deleteSupplier(int id) {
        try {
            supplierDAO.deleteSupplier(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search: Find suppliers by name
    public List<Supplier> searchSuppliersByName(String name) {
        try {
            return supplierDAO.searchSuppliersByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
