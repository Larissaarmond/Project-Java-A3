package TelaLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.UUID;
import javax.swing.JOptionPane;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/healthtech";
    private static final String USER = "root";
    private static final String PASSWORD = "Mudar123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
     public static ResultSet getConsultasForUser(int userId) throws SQLException {
        Connection conn = getConnection();
        String sql = "SELECT users.nome, users.sobrenome, users.cpf, consultas.tipoConsulta, consultas.dataConsulta, consultas.horario, consultas.doutor\n"
                + "FROM users, consultas\n"
                + "WHERE users.userId = consultas.userId AND users.userId = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, userId);
        return statement.executeQuery();
    }
     
   public static String insertUser(String nome, String sobrenome, String cpf, String email, String senha, String dataNascimento, String type_user, String codigo) {
    String insertSQL = "INSERT INTO users (nome, sobrenome, cpf, email, senha, dataNascimento, type_user, codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String userId = "";

    try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, sobrenome);
        preparedStatement.setString(3, cpf);
        preparedStatement.setString(4, email);
        preparedStatement.setString(5, senha);
        preparedStatement.setString(6, dataNascimento);
        preparedStatement.setString(7, type_user);
        preparedStatement.setString(8, codigo);

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    userId = generatedKeys.getString(1);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao salvar usuário: " + e.getMessage());
    }

    return userId;
}

    static String generateCodigo() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

}