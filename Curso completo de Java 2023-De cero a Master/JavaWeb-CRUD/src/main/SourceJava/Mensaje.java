package src.main.SourceJava;

public class Mensaje {
    private int Idmensaje;
    private String mensaje;
    private String autor;
    private String fecha;

    public Mensaje() {
    }

    public Mensaje(int Idmensaje) {
        this.Idmensaje = Idmensaje;
    }

    public Mensaje(String mensaje, String autor) {
        this.mensaje = mensaje;
        this.autor = autor;
    }

    public Mensaje(int Idmensaje, String mensaje, String autor) {
        this.Idmensaje = Idmensaje;
        this.mensaje = mensaje;
        this.autor = autor;
    }

    public Mensaje(int Idmensaje, String mensaje, String autor, String fecha) {
        this.Idmensaje = Idmensaje;
        this.mensaje = mensaje;
        this.autor = autor;
        this.fecha = fecha;
    }

    public int getIdmensaje() {
        return Idmensaje;
    }

    public void setIdmensaje(int idmensaje) {
        Idmensaje = idmensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mensaje{");
        sb.append("Idmensaje=").append(Idmensaje);
        sb.append(", mensaje='").append(mensaje).append('\'');
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", fecha='").append(fecha).append('\'');
        sb.append('}');
        return sb.toString();
    }
}