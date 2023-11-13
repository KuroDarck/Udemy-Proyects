package org.mundoPc;

// La clase Raton extiende la clase Dispositivo_de_Entrada
public class Raton extends Dispositivo_de_Entrada {

    // Atributos de la clase Raton
    private int idRaton;
    private static int contadorRaton;

    // Constructor de la clase Raton que toma dos parámetros: tipoEntrada y marca
    public Raton(String tipoEntrada, String marca) {
        // Llamada al constructor de la clase padre (Dispositivo_de_Entrada)
        super(tipoEntrada, marca);

        // Incrementa el contador estático y asigna el valor a idRaton
        this.idRaton = ++contadorRaton;
    }

    // Método getter para obtener el valor de idRaton
    public int getIdRaton() {
        return idRaton;
    }

    // Método setter para establecer el valor de idRaton
    public void setIdRaton(int idRaton) {
        this.idRaton = idRaton;
    }

    // Override del método toString para representar la información de la clase de manera personalizada
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Raton{");
        sb.append("idRaton=").append(idRaton);
        sb.append('}');
        return sb.toString();
    }
}
