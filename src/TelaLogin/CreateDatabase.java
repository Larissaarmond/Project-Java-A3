import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateDatabase {
    
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "Mudar123";

    public static void main(String[] args) {
        String dbName = "healthtech";
        
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            
            String createDatabase = "CREATE DATABASE IF NOT EXISTS " + dbName;
            statement.executeUpdate(createDatabase);
            System.out.println("Banco de dados criado com sucesso: " + dbName);
            
            String useDatabase = "USE " + dbName;
            statement.executeUpdate(useDatabase);
            
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT NOT NULL AUTO_INCREMENT,"
                    + "nome VARCHAR(50),"
                    + "sobrenome VARCHAR(50),"
                    + "cpf VARCHAR(11),"
                    + "email VARCHAR(100),"
                    + "senha VARCHAR(100),"
                    + "dataNascimento DATE,"
                    + "telefone VARCHAR(15),"
                    + "codigo VARCHAR(15),"
                    + "type_user VARCHAR(20),"
                    + "PRIMARY KEY (id))";
            statement.executeUpdate(createUsersTable);
            System.out.println("Tabela 'users' criada com sucesso.");
            
            String createConsultasTable = "CREATE TABLE IF NOT EXISTS consultas ("
                    + "id INT NOT NULL AUTO_INCREMENT,"
                    + "userId INT,"
                    + "tipoConsulta VARCHAR(50),"
                    + "horario TIME,"
                    + "dataConsulta DATE,"
                    + "doutor VARCHAR(100),"
                    + "PRIMARY KEY (id),"
                    + "FOREIGN KEY (userId) REFERENCES users(id))";
            statement.executeUpdate(createConsultasTable);
            System.out.println("Tabela 'consultas' criada com sucesso.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
