package src.main.Men;
import src.main.SourceJava.*;
import java.util.List;


public class testconeccion {

    public static void main(String[] args) {
        MensajeConsulta consulta = new MensajeConsulta();
        //Linea de Insert
        Mensaje mensaje = new Mensaje("Hijo de tu puta Madre", "RHM");
        //int insertRegister = consulta.insertMensaje(mensaje);
        // System.out.println("Register  #" + insertRegister + " Ejecutado");
        //Linea de Update
        mensaje = new Mensaje(13, "Hijo de Perro ,madre", "HIJO");
        // int updateRegister = consulta.updateMensaje(mensaje);
        //   System.out.println("Update  #" + updateRegister + " Ejecutado");

        //Linea de delet
        int deleteRegister = consulta.deletMensaje(mensaje);
        System.out.println("Delete #" + deleteRegister + " Ejecutado");
        //Linea de Select
        List<Mensaje> mensa = consulta.selectMensaje();

        for (Mensaje m : mensa) {
            System.out.println(m);
        }

    }


}