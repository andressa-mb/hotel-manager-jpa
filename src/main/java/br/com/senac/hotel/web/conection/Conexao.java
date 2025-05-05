package br.com.senac.hotel.web.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    public Connection getConexao() throws SQLException {
        Connection conexaoComBd = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexaoComBd = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbd", "root", "root123");
            System.out.println("Conexão estabelecida com o banco de dados.");
            return conexaoComBd;
        } catch (ClassNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "Driver do banco de dados não localizado! " + exception.getMessage(), "Erro", 0, null);
            return null;
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados! " + exception.getMessage(), "Erro", 0, null);
            return null;
        } finally {
            if (conexaoComBd != null) {
                conexaoComBd.close();
            }
        }
    }
}
