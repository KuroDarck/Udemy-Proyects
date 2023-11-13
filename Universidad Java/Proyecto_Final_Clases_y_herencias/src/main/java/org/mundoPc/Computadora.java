package org.mundoPc;

public class Computadora {
    // Atributos de la clase
    private int idComputadora; // Identificador único de la computadora
    private String nombreComput; // Nombre de la computadora

    // Componentes de la computadora (relaciones de composición)
    private Monitor monitor; // Objeto Monitor asociado a la computadora
    private Teclado teclado; // Objeto Teclado asociado a la computadora
    private Raton raton; // Objeto Raton asociado a la computadora

    // Atributo estático para contar el número total de computadoras creadas
    private static int contadorComputadora;

    // Constructor por defecto
    public Computadora() {
    }

    // Constructor parametrizado que inicializa los atributos de la computadora
    public Computadora(String nombreComput, Monitor monitor, Teclado teclado, Raton raton) {
        // Incrementa el contador y asigna el valor a idComputadora
        this.idComputadora = ++contadorComputadora;
        this.nombreComput = nombreComput;
        this.monitor = monitor;
        this.raton = raton;
        this.teclado = teclado;
    }

    // Métodos getter y setter para acceder y modificar los atributos de la computadora
    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public String getNombreComput() {
        return nombreComput;
    }

    public void setNombreComput(String nombreComput) {
        this.nombreComput = nombreComput;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Raton getRaton() {
        return raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    // Método toString que devuelve una representación en cadena de la computadora
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Computadora{");
        sb.append("idComputadora=").append(idComputadora);
        sb.append(", nombreComput='").append(nombreComput).append('\'');
        sb.append(", monitor=").append(monitor);
        sb.append(", teclado=").append(teclado);
        sb.append(", raton=").append(raton);
        sb.append('}');
        return sb.toString();
    }
}
