package co.edu.uniquindio.demo.demo;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String identificacion;
    private String direccion;
    private String telefono;

    public Cliente(String nombre, String apellidos, String identificacion, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono){

    }
        //..

    // Métodos CRUD
    public void crearCliente() {
        // Implementación para crear un cliente en la base de datos
    }

    public void leerCliente(String identificacion) {
        // Implementación para leer un cliente de la base de datos por identificación
    }

    public void actualizarCliente() {
        // Implementación para actualizar un cliente en la base de datos
    }

    public void eliminarCliente() {
        // Implementación para eliminar un cliente de la base de datos
    }
}



