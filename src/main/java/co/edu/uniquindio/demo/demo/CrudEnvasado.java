package co.edu.uniquindio.demo.demo;

import java.io.*;
import java.util.ArrayList;

public class CrudEnvasado {

    static String archivoEnvasado = "CRUD_ClienteEnvasado.txt";

    public void crearProductoEnvasados(ProductoEnvasado productoEnvasado){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEnvasado, true))) {
            writer.write(productoEnvasado.getCodigo() + ";"+
                    productoEnvasado.getNombre()+ productoEnvasado.getDescripcion()+productoEnvasado.getValorUnitario()
                    +productoEnvasado.getCantidadExistencia()+ productoEnvasado.getFechaEnvasado()+productoEnvasado.getPesoEnvase()
                    +productoEnvasado.getPaisOrigen()+"/n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ProductoEnvasado> leerProductoEnvasado(){
        ArrayList<PersonaJuridica> cliPersonaJuridicos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEnvasado))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(";");
                int codigo = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String descripcion = datos[2];
                double valorUnitario = Double.parseDouble(datos[3]);
                int cantidadExistencia = Integer.parseInt(datos[4]);
                String fechaEnvasado = datos[5];
                int pesoEnvase = Integer.parseInt(datos[6]);
                String paisOrigen = datos[7];
                cliPersonaJuridicos.add(new ProductoEnvasado(codigo, nombre, descripcion, valorUnitario, cantidadExistencia, fechaEnvasado, pesoEnvase, paisOrigen ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cliPersonaJuridicos;
    }



}
