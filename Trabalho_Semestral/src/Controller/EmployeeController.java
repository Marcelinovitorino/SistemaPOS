package Controller;

import DAO.EmployeeDAO;
import Model.Employee;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private final EmployeeDAO employeeDAO;

    public EmployeeController() {
        employeeDAO = new EmployeeDAO();
    }

    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    public Employee getEmployeeById(long id) throws SQLException {
        return employeeDAO.findEmployeeById(id);
    }

    public void deleteEmployee(long id) throws SQLException {
        employeeDAO.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee) throws SQLException {
        employeeDAO.updateEmployee(employee);
    }

    public List<Employee> searchEmployeesByName(String name) throws SQLException {
        return employeeDAO.searchEmployeesByName(name);
    }
}
