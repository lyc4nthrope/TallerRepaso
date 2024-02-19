package co.edu.uniquindio.demo.demo;

public class ProductoRefrigerado extends Producto{

    private String codigoAprobado;
    private String tempRecomendada;

    public ProductoRefrigerado(String codigo, String nombre, String descripcion, Float valorUnitario, int cantidadExistencia, String codigoAprobado, String tempRecomendada) {
        super(codigo, nombre, descripcion, valorUnitario, cantidadExistencia);
        this.codigoAprobado = codigoAprobado;
        this.tempRecomendada = tempRecomendada;
    }

    public String getCodigoAprobado() {
        return codigoAprobado;
    }

    public void setCodigoAprobado(String codigoAprobado) {
        this.codigoAprobado = codigoAprobado;
    }

    public String getTempRecomendada() {
        return tempRecomendada;
    }

    public void setTempRecomendada(String tempRecomendada) {
        this.tempRecomendada = tempRecomendada;
    }
}
