package co.edu.uniquindio.demo.demo;

import java.io.*;
import java.util.ArrayList;

public class CrudPerecedero {
    static String archivoPerecedero = "CRUD_ProductoPerecedero.txt";

    public void crearProductoPeres(ArrayList<ProductoPerecedero> crearProductoPerecederos){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPerecedero))) {
            for (int i =0; i<crearProductoPerecederos.size();i++){
                writer.write(crearProductoPerecederos.get(i).getCodigo()+";"
                        +crearProductoPerecederos.get(i).getNombre()+";"
                        +crearProductoPerecederos.get(i).getDescripcion()+";"
                        +crearProductoPerecederos.get(i).getValorUnitario()+";"
                        +crearProductoPerecederos.get(i).getCantidadExistencia()+";"
                        +crearProductoPerecederos.get(i).getFechaVencimiento()+"/n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void crearProductoPere(ProductoPerecedero productoPerecedero){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPerecedero, true))) {
            writer.write(productoPerecedero.getCodigo()+";"
                    +productoPerecedero.getNombre()+";"
                    +productoPerecedero.getDescripcion()+";"
                    +productoPerecedero.getValorUnitario()+";"
                    +productoPerecedero.getCantidadExistencia()+";"
                    +productoPerecedero.getFechaVencimiento()+"/n");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<ProductoPerecedero> leerProductoPerecedero(){
        ArrayList<ProductoPerecedero> cliProductoPerecederos = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(archivoPerecedero))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] datos = line.split(";");
                String codigo = datos[0];
                String nombre = datos[1];
                String descripcion = datos[2];
                double valorUnitario = Double.parseDouble(datos[3]);
                int cantidadExistencia = Integer.parseInt(datos[4]);
                String fechaVencimiento = datos[5];
                cliProductoPerecederos.add(new ProductoPerecedero(codigo, nombre, descripcion, valorUnitario, cantidadExistencia, fechaVencimiento));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return cliProductoPerecederos;
    }

    public void actualizarProductoPere(String codigo, ProductoPerecedero productoPerecedero){
        int posicion = 0;
        ArrayList<ProductoPerecedero> cliProductoPerecedero = leerProductoPerecedero();
        if (cliProductoPerecedero.get(posicion).getCodigo().equals(codigo)){
            cliProductoPerecedero.set(posicion, productoPerecedero);
        }
        crearProductoPeres(cliProductoPerecedero);
    }

    public void eliminarProductoPere(String codigo, ProductoPerecedero productoPerecedero){
        int posicion= 0;//
        ArrayList<ProductoPerecedero> cliProductoPerecedero = leerProductoPerecedero();
        if (cliProductoPerecedero.get(posicion).getCodigo().equals(codigo)){
            cliProductoPerecedero.remove(posicion);
        }

        crearProductoPeres(cliProductoPerecedero);
    }
}
