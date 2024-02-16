package co.edu.uniquindio.demo.demo;

import java.time.LocalDate;

public class ProductoEnvasado extends Producto{
    private String fechaEnvasado;
    private int pesoEnvase;
   private Pais paisOrigen;

    public ProductoEnvasado(int codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, String fechaEnvasado, int pesoEnvase, Pais paisOrigen) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public int getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(int pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public Pais getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(Pais paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
