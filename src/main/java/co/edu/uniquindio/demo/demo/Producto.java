package co.edu.uniquindio.demo.demo;

public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double valorUnitario;
    private int cantidadExistencia;

    public Producto(int codigo, String nombre, String descripcion, double valorUnitario, int cantidadExistencia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.cantidadExistencia = cantidadExistencia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    // Métodos CRUD
    public void crearProducto() {
        // Implementación para crear un producto en la base de datos
    }

    public void leerProducto(int codigo) {
        // Implementación para leer un producto de la base de datos por código
    }

    public void actualizarProducto() {
        // Implementación para actualizar un producto en la base de datos
    }

    public void eliminarProducto() {
        // Implementación para eliminar un producto de la base de datos
    }
}

