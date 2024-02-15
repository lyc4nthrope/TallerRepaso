package co.edu.uniquindio.demo.demo;

import java.time.LocalDate;

public class PersonaNatural extends Cliente{
    private String email;
    private String fechaNacimiento;

    public PersonaNatural(String nombre, String apellidos, String identificacion, String direccion, String telefono, String email, String fechaNacimiento) {
        super(nombre, apellidos, identificacion, direccion, telefono);
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
