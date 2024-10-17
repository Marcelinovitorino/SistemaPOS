package Controller;

import DAO.ExtraDAO;
import Model.Extra;
import java.sql.SQLException;
import java.util.List;

public class ExtraController {

    private ExtraDAO extraDAO;

    public ExtraController() {
        this.extraDAO = new ExtraDAO();
    }

    // Método para salvar um Extra
    public void saveExtra(String val) {
        Extra extra = new Extra();
        extra.setVal(val);
        extraDAO.save(extra);
    }

    // Método para obter todos os Extras
    public List<Extra> getAllExtras() {
        return extraDAO.findAll();
    }

    // Método para obter um Extra por ID
    public Extra getExtraById(int id) throws SQLException {
        return extraDAO.findById(id);
    }

    // Método para deletar um Extra
    public void deleteExtra(int id) throws SQLException {
        extraDAO.delete(id);
    }

    // Método para atualizar um Extra
    public void updateExtra(int id, String val) throws SQLException {
        Extra extra = new Extra(id, val);
        extraDAO.update(extra);
    }

    public boolean updateExtraVal(String val) throws SQLException {
        Extra extra = new Extra(val);
        extraDAO.updateVal(extra);
        return true;
    }
   
}
