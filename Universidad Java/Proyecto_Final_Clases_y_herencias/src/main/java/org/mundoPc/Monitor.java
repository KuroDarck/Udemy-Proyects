package org.mundoPc;

public class Monitor {
    private int idMonitor;
    private String marca;
    private double dimenciones;
    private static int   contadorMonitor;

    public Monitor(){}

    public Monitor(String marca,double dimenciones) {
        this.idMonitor=++contadorMonitor;
        this.marca=marca;
        this.dimenciones=dimenciones;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getDimenciones() {
        return dimenciones;
    }

    public void setDimenciones(double dimenciones) {
        this.dimenciones = dimenciones;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Monitor{");
        sb.append("idMonitor=").append(idMonitor);
        sb.append(", marca='").append(marca).append('\'');
        sb.append(", dimenciones=").append(dimenciones);
        sb.append('}');
        return sb.toString();
    }
}
