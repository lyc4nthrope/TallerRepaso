package co.edu.uniquindio.demo.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CrudNatural {
    String archivo="CRUD_ClienteNatu.txt";
    public void crearClienteNatu(PersonaNatural personaNatural) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivo,true))) {
            writer.write(personaNatural.getNombre()+";"
                    + personaNatural.getApellidos()+";"+ personaNatural.getIdentificacion()
            +";"+ personaNatural.getDireccion()+";"+ personaNatural.getTelefono()+";"+personaNatural.getEmail()+
                    ";"+personaNatural.getFechaNacimiento()+"/n");

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<PersonaNatural> leerClienteNatu(String identificacion) {
        // Implementación para leer un cliente de la base de datos por identificación
        ArrayList<PersonaNatural> cliPersonaNaturals = new ArrayList<>();

        return  cliPersonaNaturals;
    }

    public void actualizarClienteNatu(int identificacion, PersonaNatural  personaNatural) {

    }

    public void eliminarClienteNatu(int identificacion) {
        // Implementación para eliminar un cliente de la base de datos
    }
    public void crearClientesNatus(ArrayList<PersonaNatural> cliPersonaNaturals) {
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

}
