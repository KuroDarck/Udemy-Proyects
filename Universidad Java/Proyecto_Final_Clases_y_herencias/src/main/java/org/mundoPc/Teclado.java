package org.mundoPc;

// La clase Teclado hereda de la clase Dispositivo_de_Entrada
public class Teclado extends Dispositivo_de_Entrada {

    // Atributos de la clase Teclado
    private int idTeclado;
    private static int contadorTeclado;

    // Constructor de la clase Teclado que recibe tipoEntrada y marca como parámetros
    public Teclado(String tipoEntrada, String marca) {
        // Llama al constructor de la clase padre (Dispositivo_de_Entrada) con los parámetros dados
        super(tipoEntrada, marca);
        // Incrementa el contadorTeclado y lo asigna al idTeclado actual
        this.idTeclado = ++contadorTeclado;
    }

    // Método getter para obtener el valor de idTeclado
    public int getIdTeclado() {
        return idTeclado;
    }

    // Método setter para establecer el valor de idTeclado
    public void setIdTeclado(int idTeclado) {
        this.idTeclado = idTeclado;
    }

    // Sobrescribe el método toString para proporcionar una representación de cadena de la clase
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teclado{");
        sb.append("idTeclado=").append(idTeclado);
        sb.append('}');
        return sb.toString();
    }
}

