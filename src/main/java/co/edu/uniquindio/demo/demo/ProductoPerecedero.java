package co.edu.uniquindio.demo.demo;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto{

    private String fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, String fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
