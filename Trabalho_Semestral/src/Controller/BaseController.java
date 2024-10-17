package Controller;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseController<T> {

    // Método para salvar um objeto (CREATE)
    public void save(T obj) throws SQLException {
        System.out.println("Salvando objeto genérico...");
    }

    // Método para buscar todos os objetos (READ)
    public List<T> findAll() throws SQLException {
        System.out.println("Buscando todos os objetos genéricos...");
        return null;
    }

    // Método para buscar um objeto por ID (READ)
    public T findById(int id) throws SQLException {
        System.out.println("Buscando objeto genérico pelo ID...");
        return null;
    }

    // Método para atualizar um objeto (UPDATE)
    public void update(T obj) throws SQLException {
        System.out.println("Atualizando objeto genérico...");
    }

    // Método para deletar um objeto (DELETE)
    public void deleteById(int id) throws SQLException {
        System.out.println("Deletando objeto genérico pelo ID...");
    }

    // Método para buscar objetos por nome (SEARCH)
    public List<T> searchByName(String name) throws SQLException {
        System.out.println("Buscando objetos genéricos pelo nome...");
        return null;
    }
}
