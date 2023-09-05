package src.main.SourceJava;

import java.sql.*;


public class Conexion implements CRUD {

    private static final String UrlBaseDate = "jdbc:mysql://localhost/mensajes?serverTimezone=UTC";
    private static final String username = "root_java";
    private static final String password = "12345";

    public static Connection initConecion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(UrlBaseDate, username, password);
    }

    public static void CerrarConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void CerrarConnection(PreparedStatement sqlStatement) throws SQLException {
        sqlStatement.close();
    }

    public static void CerrarConnection(ResultSet resultado) throws SQLException {
        resultado.close();
    }

}
