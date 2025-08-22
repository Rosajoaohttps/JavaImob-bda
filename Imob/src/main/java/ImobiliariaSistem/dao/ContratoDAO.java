package imobiliaria.dao;

import java.sql.*;
import imobiliaria.database.ConnectionFactory;

public class ContratoDAO {
    public void inserir(int clienteId, int imovelId, Date data) {
        String sql = "INSERT INTO Contrato (cliente_id, imovel_id, data) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, clienteId);
            stmt.setInt(2, imovelId);
            stmt.setDate(3, data);
            stmt.executeUpdate();

            System.out.println("Contrato inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
