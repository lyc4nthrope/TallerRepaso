package co.edu.uniquindio.demo.demo;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class CrudJuridico {

    static String archivoJuridico = "CRUD_ClienteJuridico.txt";

    public static void crearClientesJuridico(PersonaJuridica personaJuridica) {
        if (existeId(personaJuridica.getIdentificacion())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Cliente ya registrado");
            alert.showAndWait();
        }else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJuridico, true))) {
                writer.write(personaJuridica.getNombre() + ";"
                        + personaJuridica.getApellidos() + ";" + personaJuridica.getIdentificacion()
                        + ";" + personaJuridica.getDireccion() + ";" + personaJuridica.getTelefono() + ";" + personaJuridica.getNit() + ";\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
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
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJuridico, true));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

        return cliPersonaJuridicos;
    }

    // crear un buscador
    public static void actualizarClienteJuri(PersonaJuridica personaJuridica, String identificacion) {
        //buscadorPersonaNatural(identificacion);
        ArrayList<PersonaJuridica> cliPersonaJuridicos = leerClienteJuridico();
        for (int i = 0; i < cliPersonaJuridicos.size(); i++) {
            if (cliPersonaJuridicos.get(i).getIdentificacion().equals(identificacion)){
                cliPersonaJuridicos.set(i,personaJuridica);
            }
        }
        crearClientesJuridicos(cliPersonaJuridicos);
    }

    public static void eliminarClienteJuri(String identificacion) {
        // Implementación para eliminar un cliente de la base de datos
        //delete  from db_amacen TablaNatural where identificacion = "identificacion";
        //update from db_amacen TablaNatural (nombre,apellido,....) values (nombre,apellido,....) where identificacion = "identificacion"
        //buscadorPersonaNatural(identificacion);
        ArrayList<PersonaJuridica> cliPersonaJuridicos = leerClienteJuridico();
        for (int i = 0; i < cliPersonaJuridicos.size(); i++) {
            if (cliPersonaJuridicos.get(i).getIdentificacion().equals(identificacion)){
                cliPersonaJuridicos.remove(i);
            }
        }

        crearClientesJuridicos(cliPersonaJuridicos);
    }

    public static void crearClientesJuridicos(ArrayList<PersonaJuridica> crearClientesJuridicos ){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJuridico))) {
            for (int i=0 ; i< crearClientesJuridicos.size(); i++){
                writer.write(crearClientesJuridicos.get(i).getNombre()+ ";"
                                +crearClientesJuridicos.get(i).getApellidos()+";"+
                        crearClientesJuridicos.get(i).getIdentificacion()+";"+
                        crearClientesJuridicos.get(i).getDireccion()+";"+
                        crearClientesJuridicos.get(i).getTelefono()+";"+crearClientesJuridicos.get(i).getNit()+";\n");

            }
        }catch (IOException e){
            e.printStackTrace();

        }
    }

    public static boolean existeId(String id){
        boolean existe = false;
        ArrayList<PersonaJuridica> listaClientesJuridicos = leerClienteJuridico();
        for (int i = 0; i < listaClientesJuridicos.size()&&!existe; i++) {
            if (id.equals(listaClientesJuridicos.get(i).getIdentificacion())){
                existe=true;
            }
        }
        return existe;
    }
}
