package co.edu.uniquindio.demo.demo;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class CrudRefrigerado {
    static String archivoRefrigerado = "CRUD_ProductoRefregerado.txt";

    public static void crearProductoRefris(ArrayList<ProductoRefrigerado> crearProductoRefrigerados){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRefrigerado))) {
            for (int i =0; i<crearProductoRefrigerados.size();i++){
                writer.write(crearProductoRefrigerados.get(i).getCodigo()+";"
                        +crearProductoRefrigerados.get(i).getNombre()+";"
                        +crearProductoRefrigerados.get(i).getDescripcion()+";"
                        +crearProductoRefrigerados.get(i).getValorUnitario()+";"
                        +crearProductoRefrigerados.get(i).getCantidadExistencia()+";"
                        +crearProductoRefrigerados.get(i).getCodigoAprobado()+";"
                        +crearProductoRefrigerados.get(i).getTempRecomendada()+";\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void crearProductoRefri(ProductoRefrigerado productoRefrigerado){

        if (existeId(productoRefrigerado.getCodigo())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Cliente ya registrado");
            alert.showAndWait();
        }else {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRefrigerado, true))) {
                writer.write(productoRefrigerado.getCodigo()+";"
                        +productoRefrigerado.getNombre()+";"
                        +productoRefrigerado.getDescripcion()+";"
                        +productoRefrigerado.getValorUnitario()+";"
                        +productoRefrigerado.getCantidadExistencia()+";"
                        +productoRefrigerado.getCodigoAprobado()+";"
                        +productoRefrigerado.getTempRecomendada()+";\n");

            }catch (IOException e){
                e.printStackTrace();
            }
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
                Float valorUnitario = Float.parseFloat(datos[3]);
                int cantidadExistencia = Integer.parseInt(datos[4]);
                String  codigoAprobado= datos[5];
                String tempRecomendada = datos[6];
                cliProductoRefrigerados.add(new ProductoRefrigerado(codigo, nombre, descripcion, valorUnitario, cantidadExistencia, codigoAprobado, tempRecomendada));
            }
        }catch (IOException e){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRefrigerado, true));
            }catch (IOException ex){
                throw new RuntimeException();
            }
        }
        return cliProductoRefrigerados;
    }

    public static void actualizarProductoRefri(ProductoRefrigerado productoRefrigerado,String codigo){

        ArrayList<ProductoRefrigerado> cliProductoRefrigerado = leerProductoRefrigerados();
        for (int i = 0; i < cliProductoRefrigerado.size() ; i++) {
            if (cliProductoRefrigerado.get(i).getCodigo().equals(codigo)){
                cliProductoRefrigerado.set(i, productoRefrigerado);
            }
        }
        crearProductoRefris(cliProductoRefrigerado);
    }

    public static void eliminarProductoRefri(String codigo){
        ArrayList<ProductoRefrigerado> cliProductoRefrigerado = leerProductoRefrigerados();
        for (int i = 0; i < cliProductoRefrigerado.size(); i++) {
            if (cliProductoRefrigerado.get(i).getCodigo().equals(codigo)){
                cliProductoRefrigerado.remove(i);
            }
        }
        crearProductoRefris(cliProductoRefrigerado);
    }
    public static boolean existeId(String codigo){
        boolean existe = false;
        ArrayList<ProductoRefrigerado> listaProductoRefrijerado= leerProductoRefrigerados();
        for (int i = 0; i < listaProductoRefrijerado.size()&&!existe; i++) {
            if (codigo.equals(listaProductoRefrijerado.get(i).getCodigo())){
                existe=true;
            }
        }
        return existe;
    }
}
