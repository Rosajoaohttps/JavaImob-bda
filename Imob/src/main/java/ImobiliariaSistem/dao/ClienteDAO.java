package imobiliaria.dao;

import java.sql.*;
import imobiliaria.database.ConnectionFactory;

public class ClienteDAO {
    public void inserir(String nome, String email) {
        String sql = "INSERT INTO Cliente (nome, email) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();

            System.out.println("Cliente inserido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
