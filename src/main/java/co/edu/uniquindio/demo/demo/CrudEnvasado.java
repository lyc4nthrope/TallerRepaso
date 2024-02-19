package co.edu.uniquindio.demo.demo;

import javafx.scene.control.Alert;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static co.edu.uniquindio.demo.demo.CrudJuridico.leerClienteJuridico;

public class CrudEnvasado {

    static String archivoEnvasado = "CRUD_ProductoEnvasado.txt";

    public static void crearProductoEnvasado(ProductoEnvasado productoEnvasado) {
        if (existeCodigo(productoEnvasado.getCodigo())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Producto ya registrado");
            alert.showAndWait();
        }else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEnvasado, true))) {
                writer.write(productoEnvasado.getCodigo() + ";" +
                        productoEnvasado.getNombre() +";"+ productoEnvasado.getDescripcion()+";" + productoEnvasado.getValorUnitario()
                        +";"+ productoEnvasado.getCantidadExistencia() +";"+ productoEnvasado.getFechaEnvasado() +";"+ productoEnvasado.getPesoEnvase()
                        +";"+ productoEnvasado.getPaisOrigen() + ";\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
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
                Float valorUnitario = Float.parseFloat(datos[3]);
                int cantidadExistencia = Integer.parseInt(datos[4]);
                LocalDate fechaEnvasado = LocalDate.parse(datos[5]);
                int pesoEnvase = Integer.parseInt(datos[6]);
                String paisOrigen = datos[7];
                cliProductoEnvasado.add(new ProductoEnvasado(codigo, nombre, descripcion, valorUnitario, cantidadExistencia, fechaEnvasado, pesoEnvase, paisOrigen));
            }

        }catch (IOException e){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEnvasado, true));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        return cliProductoEnvasado;
    }

    public static void actualizarProductoEn(ProductoEnvasado productoEnvasado,String codigo){
        //buscadorPersonaNatural(identificacion);
        ArrayList<ProductoEnvasado> auxProductoEnvasados = leerProductoEnvasado();
        for (int i = 0; i < auxProductoEnvasados.size(); i++) {
            if (auxProductoEnvasados.get(i).getCodigo().equals(codigo)){
                auxProductoEnvasados.set(i,productoEnvasado);
            }
        }

        crearProductoEnvasados(auxProductoEnvasados);
    }
    public static void eliminarProductoEnva(String codigo){
        ArrayList<ProductoEnvasado> cliProductoEnvasado = leerProductoEnvasado();
        for (int i = 0; i < cliProductoEnvasado.size(); i++) {
            if (cliProductoEnvasado.get(i).getCodigo().equals(codigo)){
                cliProductoEnvasado.remove(i);
            }
        }
        crearProductoEnvasados(cliProductoEnvasado);
    }

    public static void crearProductoEnvasados(ArrayList<ProductoEnvasado> crearProductoEnvasados){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoEnvasado))) {
            for (int i= 0; i< crearProductoEnvasados.size(); i++ ){
                writer.write(crearProductoEnvasados.get(i).getCodigo()+";"
                        +crearProductoEnvasados.get(i).getNombre()+";"
                        +crearProductoEnvasados.get(i).getDescripcion()+";"
                        +crearProductoEnvasados.get(i).getValorUnitario()+";"
                        +crearProductoEnvasados.get(i).getCantidadExistencia()+";"
                        +crearProductoEnvasados.get(i).getFechaEnvasado()+";"
                        +crearProductoEnvasados.get(i).getPesoEnvase()+";"
                        +crearProductoEnvasados.get(i).getPaisOrigen()+";\n");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static boolean existeCodigo(String codigo){
        boolean existe = false;
        ArrayList<ProductoEnvasado> productosEnvasados = leerProductoEnvasado();
        for (int i = 0; i < productosEnvasados.size()&&!existe; i++) {
            if (codigo.equals(productosEnvasados.get(i).getCodigo())){
                existe=true;
            }
        }
        return existe;
    }
}
