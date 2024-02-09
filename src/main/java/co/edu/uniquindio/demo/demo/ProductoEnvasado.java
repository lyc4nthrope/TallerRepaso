package co.edu.uniquindio.demo.demo;

import java.time.LocalDate;

public class ProductoEnvasado extends Producto{
    private LocalDate fechaEnvasado;
    private int pesoEnvase;
   private Pais paisOrigen;

    public ProductoEnvasado(int codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, LocalDate fechaEnvasado, int pesoEnvase, Pais paisOrigen) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
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
