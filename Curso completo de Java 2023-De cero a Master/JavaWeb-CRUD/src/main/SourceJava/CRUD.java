package src.main.SourceJava;

import java.sql.SQLException;

public interface CRUD {
    static void conecion(String bdsName, String user, String password) throws SQLException {}
    static void Insertar(String sql) throws SQLException {}
    static void Actualizar(String sql) throws SQLException {}
    static void Eliminar(String sql) throws SQLException {}
    static void Consultar(String sql) throws SQLException {}
}

