package imobiliaria.model;

import imobiliaria.database.DatabaseCreator;
import imobiliaria.dao.ClienteDAO;
import imobiliaria.dao.ImovelDAO;
import imobiliaria.dao.ContratoDAO;

import java.sql.Date;

public class App {
    public static void main(String[] args) {
        // Cria o banco de dados e tabelas
        DatabaseCreator.createDatabase();

        // Testa inserção
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserir("João Rosa", "joao@email.com");

        ImovelDAO imovelDAO = new ImovelDAO();
        imovelDAO.inserir("Rua das Flores, 123", 350000.00);

        ContratoDAO contratoDAO = new ContratoDAO();
        contratoDAO.inserir(1, 1, Date.valueOf("2025-08-22"));
    }
}
