package co.edu.uniquindio.demo.demo;

public class PersonaJuridica extends Cliente {
    private String nit;

    public PersonaJuridica(String nombre, String apellidos, String identificacion, String direccion, String telefono, String nit) {
        super(nombre, apellidos, identificacion, direccion, telefono);
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
