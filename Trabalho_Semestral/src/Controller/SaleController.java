package Controller;

import DAO.SaleDAO;
import Model.Sale;
import java.sql.SQLException;
import java.util.List;

public class SaleController {
    private final SaleDAO saleDAO;

    public SaleController() {
        saleDAO = new SaleDAO();
    }

    public void saveSale(Sale sale) {
        saleDAO.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleDAO.findAll();
    }

    public Sale getSaleById(int id) throws SQLException {
        return saleDAO.findSaleById(id);
    }

    public void deleteSale(int id) throws SQLException {
        saleDAO.deleteSale(id);
    }

    public void updateSale(Sale sale) throws SQLException {
        saleDAO.updateSale(sale);
    }

    public List<Sale> searchSalesByName(String nomeCliente) throws SQLException {
        return saleDAO.searchSalesByName(nomeCliente);
    }
}
