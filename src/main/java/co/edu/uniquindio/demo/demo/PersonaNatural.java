package co.edu.uniquindio.demo.demo;

import java.time.LocalDate;

public class PersonaNatural extends Cliente{
    private String email;
    private LocalDate fechaNacimiento;

    public PersonaNatural(String nombre, String apellidos, String identificacion, String direccion, String telefono, String email, LocalDate fechaNacimiento) {
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
