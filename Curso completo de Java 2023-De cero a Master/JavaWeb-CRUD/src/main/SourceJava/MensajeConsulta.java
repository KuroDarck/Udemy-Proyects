package src.main.SourceJava;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensajeConsulta {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Mensaje> selectMensaje() {
        String sqlConsulta = "SELECT * FROM mensaje";
        List<Mensaje> mensajes = new ArrayList<>();

        try {
            this.con = Conexion.initConecion();
            this.ps = this.con.prepareStatement(sqlConsulta);
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                int id = this.rs.getInt("idmensaje");
                String mensajeText = this.rs.getString("mensajes");
                String autor = this.rs.getString("autor");
                String date = this.rs.getString("fecha");

                Mensaje mensaje = new Mensaje(id, mensajeText, autor, date);
                mensajes.add(mensaje);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Conexion.CerrarConnection(this.rs);
                Conexion.CerrarConnection(this.ps);
                Conexion.CerrarConnection(this.con);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return mensajes;
    }

    public int insertMensaje(@NotNull Mensaje mensaje) {
        String sqlConsulta = "INSERT INTO mensaje (mensajes, autor, fecha) VALUES (?, ?, current_date())";
        int registroUDP=0;

        try {
            this.con = Conexion.initConecion();
            this.ps = this.con.prepareStatement(sqlConsulta);
            this.ps.setString(1, mensaje.getMensaje());
            this.ps.setString(2, mensaje.getAutor());
           registroUDP= this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Conexion.CerrarConnection(this.ps);
                Conexion.CerrarConnection(this.con);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return registroUDP;
    }

    public int updateMensaje(@NotNull Mensaje mensaje) {
        String sqlConsulta = "UPDATE mensaje SET mensajes=?, autor=? WHERE idmensaje=?";
        int registroUDP=0;

        try {
            this.con = Conexion.initConecion();
            this.ps = this.con.prepareStatement(sqlConsulta);
            this.ps.setString(1, mensaje.getMensaje());
            this.ps.setString(2, mensaje.getAutor());
            this.ps.setInt(3, mensaje.getIdmensaje());
            registroUDP= this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Conexion.CerrarConnection(this.ps);
                Conexion.CerrarConnection(this.con);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return registroUDP;
    }

    public int  deletMensaje(@NotNull Mensaje mensaje) {
        String sqlConsulta = "DELETE FROM mensaje WHERE idmensaje=?";
        int registroDt=0;

        try {
            this.con = Conexion.initConecion();
            this.ps = this.con.prepareStatement(sqlConsulta);
            this.ps.setInt(1, mensaje.getIdmensaje());
            registroDt= this.ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                Conexion.CerrarConnection(this.ps);
                Conexion.CerrarConnection(this.con);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return registroDt;
    }
}
