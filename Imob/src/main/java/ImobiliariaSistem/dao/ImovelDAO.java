package imobiliaria.dao;

import java.sql.*;
import imobiliaria.database.ConnectionFactory;

public class ImovelDAO {
    public void inserir(String endereco, double valor) {
        String sql = "INSERT INTO Imovel (endereco, valor) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, endereco);
            stmt.setDouble(2, valor);
            stmt.executeUpdate();

            System.out.println("Imóvel inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
