package co.edu.uniquindio.demo.demo;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto{

    private LocalDate fechaVencimiento;

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public ProductoPerecedero(int codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia, LocalDate fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.fechaVencimiento = fechaVencimiento;


    }

}
