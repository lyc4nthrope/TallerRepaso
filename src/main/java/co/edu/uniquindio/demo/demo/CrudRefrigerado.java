package co.edu.uniquindio.demo.demo;

import java.io.*;
import java.util.ArrayList;

public class CrudRefrigerado {
    static String archivoRefrigerado = "CRUD_ProductoRefregerado.txt";

    public void crearProductoRefris(ArrayList<ProductoRefrigerado> crearProductoRefrigerados){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRefrigerado))) {
            for (int i =0; i<crearProductoRefrigerados.size();i++){
                writer.write(crearProductoRefrigerados.get(i).getCodigo()+";"
                        +crearProductoRefrigerados.get(i).getNombre()+";"
                        +crearProductoRefrigerados.get(i).getDescripcion()+";"
                        +crearProductoRefrigerados.get(i).getValorUnitario()+";"
                        +crearProductoRefrigerados.get(i).getCantidadExistencia()+";"
                        +crearProductoRefrigerados.get(i).getCodigoAprobado()+";"
                        +crearProductoRefrigerados.get(i).getTempRecomendada()+"/n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void crearProductoRefri(ProductoRefrigerado productoRefrigerado){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRefrigerado, true))) {
            writer.write(productoRefrigerado.getCodigo()+";"
                    +productoRefrigerado.getNombre()+";"
                    +productoRefrigerado.getDescripcion()+";"
                    +productoRefrigerado.getValorUnitario()+";"
                    +productoRefrigerado.getCantidadExistencia()+";"
                    +productoRefrigerado.getCodigoAprobado()+";"
                    +productoRefrigerado.getTempRecomendada()+"/n");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<ProductoRefrigerado> leerProductoRefrigerados(){
        ArrayList<ProductoRefrigerado> cliProductoRefrigerados = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(archivoRefrigerado))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] datos = line.split(";");
                String codigo = datos[0];
                String nombre = datos[1];
                String descripcion = datos[2];
                double valorUnitario = Double.parseDouble(datos[3]);
                int cantidadExistencia = Integer.parseInt(datos[4]);
                String  codigoAprobado= datos[5];
                String tempRecomendada = datos[6];
                cliProductoRefrigerados.add(new ProductoRefrigerado(codigo, nombre, descripcion, valorUnitario, cantidadExistencia, codigoAprobado, tempRecomendada));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return cliProductoRefrigerados;
    }

    public void actualizarProductoRefri(String codigo, ProductoRefrigerado productoRefrigerado){
        int posicion = 0;
        ArrayList<ProductoRefrigerado> cliProductoRefrigerado = leerProductoRefrigerados();
        if (cliProductoRefrigerado.get(posicion).getCodigo().equals(codigo)){
            cliProductoRefrigerado.set(posicion, productoRefrigerado);
        }
        crearProductoRefris(cliProductoRefrigerado);
    }

    public void eliminarProductoRefri(String codigo, ProductoRefrigerado productoRefrigerado){
        int posicion= 0;//
        ArrayList<ProductoRefrigerado> cliProductoRefrigerado = leerProductoRefrigerados();
        if (cliProductoRefrigerado.get(posicion).getCodigo().equals(codigo)){
            cliProductoRefrigerado.remove(posicion);
        }

        crearProductoRefris(cliProductoRefrigerado);
    }
}
