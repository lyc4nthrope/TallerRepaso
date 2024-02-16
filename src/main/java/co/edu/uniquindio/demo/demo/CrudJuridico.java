package co.edu.uniquindio.demo.demo;

import java.io.*;
import java.util.ArrayList;

public class CrudJuridico {

    static String archivoJuridico = "CRUD_ClienteJuridico.txt";

    public void crearClientesJuridico(PersonaJuridica personaJuridica) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJuridico, true))) {
            writer.write(personaJuridica.getNombre() + ";"
                    + personaJuridica.getApellidos() + ";" + personaJuridica.getIdentificacion()
                    + ";" + personaJuridica.getDireccion() + ";" + personaJuridica.getTelefono() + ";" + personaJuridica.getNit() + "/n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<PersonaJuridica> leerClienteJuridico() {
        // Implementación para leer un cliente de la base de datos por identificación
        ArrayList<PersonaJuridica> cliPersonaJuridicos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoJuridico))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(";");
                String nombre = datos[0];
                String apellidos = datos[1];
                String identificacion = datos[2];
                String direccion = datos[3];
                String telefono = datos[4];
                String nit = datos[5];
                cliPersonaJuridicos.add(new PersonaJuridica(nombre, apellidos, identificacion, direccion, telefono, nit));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cliPersonaJuridicos;

    }

    // crear un buscador
    public void actualizarClienteJuri(String identificacion, PersonaJuridica personaJuridica) {
        int posicion= 0;//buscadorPersonaNatural(identificacion);
        ArrayList<PersonaJuridica> cliPersonaJuridicos = leerClienteJuridico();
        if (cliPersonaJuridicos.get(posicion).getIdentificacion().equals(identificacion)){
            cliPersonaJuridicos.set(posicion,personaJuridica);
        }
        crearClientesJuridicos(cliPersonaJuridicos);
    }

    public void eliminarClienteJuri(String identificacion, PersonaJuridica personaJuridica) {
        // Implementación para eliminar un cliente de la base de datos
        //delete  from db_amacen TablaNatural where identificacion = "identificacion";
        //update from db_amacen TablaNatural (nombre,apellido,....) values (nombre,apellido,....) where identificacion = "identificacion"
        int posicion= 0;//buscadorPersonaNatural(identificacion);
        ArrayList<PersonaJuridica> cliPersonaJuridicos = leerClienteJuridico();
        if (cliPersonaJuridicos.get(posicion).getIdentificacion().equals(identificacion)){
            cliPersonaJuridicos.remove(posicion);
        }
        crearClientesJuridicos(cliPersonaJuridicos);
    }

    public void crearClientesJuridicos(ArrayList<PersonaJuridica> crearClientesJuridicos ){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJuridico))) {
            for (int i=0 ; i< crearClientesJuridicos.size(); i++){
                writer.write(crearClientesJuridicos.get(i).getNombre()+ ";"
                                +crearClientesJuridicos.get(i).getApellidos()+";"+
                        crearClientesJuridicos.get(i).getIdentificacion()+";"+
                        crearClientesJuridicos.get(i).getDireccion()+";"+
                        crearClientesJuridicos.get(i).getTelefono()+";"+crearClientesJuridicos.get(i).getNit()+"/n");

            }

        }catch (IOException e){
            e.printStackTrace();

        }
    }

}
