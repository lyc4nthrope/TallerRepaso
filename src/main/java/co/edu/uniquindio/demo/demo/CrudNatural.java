package co.edu.uniquindio.demo.demo;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class CrudNatural {
    static String archivo="CRUD_ClienteNatu.txt";
    public static void crearClienteNatu(PersonaNatural personaNatural) {

        if (existeId(personaNatural.getIdentificacion())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Cliente ya registrado");
            alert.showAndWait();
        }else {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo,true))) {
                writer.write(personaNatural.getNombre()+";"
                        + personaNatural.getApellidos()+";"+ personaNatural.getIdentificacion()
                        +";"+ personaNatural.getDireccion()+";"+ personaNatural.getTelefono()+";"+personaNatural.getEmail()+
                        ";"+personaNatural.getFechaNacimiento()+"/n");

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public static ArrayList<PersonaNatural> leerClienteNatu() {
        // Implementación para leer un cliente de la base de datos por identificación
        ArrayList<PersonaNatural> cliPersonaNaturals = new ArrayList<>();
        try(BufferedReader reader= new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] datos= line.split(";");
                String nombre = datos[0];
                String apellidos=datos[1];
                String identificacion = datos[2];
                String direccion= datos[3];
                String telefono= datos[4];
                String email=datos[5];
                String fechaNacimiento = datos[6];
                cliPersonaNaturals.add(new PersonaNatural(nombre,apellidos,identificacion,direccion,telefono,email,fechaNacimiento));
            }
        }catch (IOException e){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
            }catch (IOException ex){
                throw new RuntimeException(ex);
            }
        }
        return  cliPersonaNaturals;
    }


// crear un buscador
    public static void actualizarClienteNatu(PersonaNatural personaNatural, String identificacion) {
        int posicion= 0;//buscadorPersonaNatural(identificacion);
        ArrayList<PersonaNatural> cliPersonaNaturals = leerClienteNatu();
        for (int i = 0; i <cliPersonaNaturals.size() ; i++) {
            if (cliPersonaNaturals.get(posicion).getIdentificacion().equals(identificacion)){
                cliPersonaNaturals.set(posicion,personaNatural);
            }
        }
        crearClientesNatus(cliPersonaNaturals);
    }

    public static void eliminarClienteNatu(String identificacion) {
        // Implementación para eliminar un cliente de la base de datos
        //delete  from db_amacen TablaNatural where identificacion = "identificacion";
        //update from db_amacen TablaNatural (nombre,apellido,....) values (nombre,apellido,....) where identificacion = "identificacion"
        int posicion= 0;//buscadorPersonaNatural(identificacion);
        ArrayList<PersonaNatural> cliPersonaNaturals = leerClienteNatu();
        for (int i = 0; i <cliPersonaNaturals.size() ; i++) {
            if (cliPersonaNaturals.get(posicion).getIdentificacion().equals(identificacion)){
                cliPersonaNaturals.remove(posicion);
            }
        }
        crearClientesNatus(cliPersonaNaturals);
    }
    public static void crearClientesNatus(ArrayList<PersonaNatural> cliPersonaNaturals) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int i=0; i < cliPersonaNaturals.size();i++){
                writer.write(cliPersonaNaturals.get(i).getNombre()+";"
                        + cliPersonaNaturals.get(i).getApellidos()+";"+ cliPersonaNaturals.get(i).getIdentificacion()
                        +";"+ cliPersonaNaturals.get(i).getDireccion()+";"+ cliPersonaNaturals.get(i).getTelefono()+";"
                        +cliPersonaNaturals.get(i).getEmail()+
                        ";"+cliPersonaNaturals.get(i).getFechaNacimiento()+"/n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean existeId(String id){
        boolean existe = false;
        ArrayList<PersonaNatural> listaClientesNaturales= leerClienteNatu();
        for (int i = 0; i < listaClientesNaturales.size()&&!existe; i++) {
            if (id.equals(listaClientesNaturales.get(i).getIdentificacion())){
                existe=true;
            }
        }
        return existe;
    }
}
