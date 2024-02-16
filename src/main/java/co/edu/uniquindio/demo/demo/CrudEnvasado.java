package co.edu.uniquindio.demo.demo;

import java.io.*;
import java.util.ArrayList;

public class CrudEnvasado {

    static String archivoEnvasado = "CRUD_ClienteEnvasado.txt";

    public void crearProductoEnvasado(ProductoEnvasado productoEnvasado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEnvasado, true))) {
            writer.write(productoEnvasado.getCodigo() + ";" +
                    productoEnvasado.getNombre() + productoEnvasado.getDescripcion() + productoEnvasado.getValorUnitario()
                    + productoEnvasado.getCantidadExistencia() + productoEnvasado.getFechaEnvasado() + productoEnvasado.getPesoEnvase()
                    + productoEnvasado.getPaisOrigen() + "/n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ProductoEnvasado> leerProductoEnvasado(){

        ArrayList<ProductoEnvasado> cliProductoEnvasado = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(archivoEnvasado))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] datos = line.split(";");
                String codigo = datos[0];
                String nombre = datos[1];
                String descripcion = datos[2];
                double valorUnitario = Double.parseDouble(datos[3]);
                int cantidadExistencia = Integer.parseInt(datos[4]);
                String fechaEnvasado = datos[5];
                int pesoEnvase = Integer.parseInt(datos[6]);
                String paisOrigen = datos[7];
                cliProductoEnvasado.add(new ProductoEnvasado(codigo, nombre, descripcion, valorUnitario, cantidadExistencia, fechaEnvasado, pesoEnvase, paisOrigen));
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return cliProductoEnvasado;
    }

    public void actualizarProductoEn(String codigo, ProductoEnvasado productoEnvasado){
        int posicion= 0;//buscadorPersonaNatural(identificacion);
        ArrayList<ProductoEnvasado> cliProductoEnvasado = leerProductoEnvasado();
        if (cliProductoEnvasado.get(posicion).getCodigo().equals(codigo)){
            cliProductoEnvasado.set(posicion,productoEnvasado
            );
        }
        crearProductoEnvasados(cliProductoEnvasado);
    }
    public void eliminarProductoEnva(String codigo,ProductoEnvasado productoEnvasado){
        int posicion= 0;//
        ArrayList<ProductoEnvasado> cliProductoEnvasado = leerProductoEnvasado();
        if (cliProductoEnvasado.get(posicion).getCodigo().equals(codigo)){
            cliProductoEnvasado.remove(posicion);
        }

        crearProductoEnvasados(cliProductoEnvasado);
    }

    public void crearProductoEnvasados(ArrayList<ProductoEnvasado> crearProductoEnvasados){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEnvasado))) {
            for (int i= 0; i< crearProductoEnvasados.size(); i++ ){
                writer.write(crearProductoEnvasados.get(i).getCodigo()+";"
                        +crearProductoEnvasados.get(i).getNombre()+";"
                        +crearProductoEnvasados.get(i).getDescripcion()+";"
                        +crearProductoEnvasados.get(i).getValorUnitario()+";"
                        +crearProductoEnvasados.get(i).getCantidadExistencia()+";"
                        +crearProductoEnvasados.get(i).getFechaEnvasado()+";"
                        +crearProductoEnvasados.get(i).getPesoEnvase()+";"
                        +crearProductoEnvasados.get(i).getPaisOrigen()+"/n");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
