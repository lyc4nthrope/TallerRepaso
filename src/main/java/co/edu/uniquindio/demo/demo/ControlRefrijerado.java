package co.edu.uniquindio.demo.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ControlRefrijerado implements Initializable {
    ArrayList<ProductoRefrigerado> listaProductoRefrijerado = CrudRefrigerado.leerProductoRefrigerados();
    @FXML
    private TableColumn<ProductoRefrigerado, String> jurCodigo;

    @FXML
    private TableColumn<ProductoRefrigerado, String> jurNombre;

    @FXML
    private TableColumn<ProductoRefrigerado, String> jurDescripcion;

    @FXML
    private TableColumn<ProductoRefrigerado, String> jurValorU;

    @FXML
    private TableColumn<ProductoRefrigerado, Integer> jurCantidad;

    @FXML
    private TableColumn<ProductoRefrigerado, String> jurCodAprovado;

    @FXML
    private TableColumn<ProductoRefrigerado, String> jurTemp;

    @FXML
    private TableView<ProductoRefrigerado> tablaProductosRefrijerados;

    ObservableList<ProductoRefrigerado> listaProductosRefrijeradosObservable = FXCollections.observableList(listaProductoRefrijerado);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jurCodigo.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, String>("codigo"));
        jurNombre.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, String>("nombre"));
        jurDescripcion.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, String>("descripcion"));
        jurValorU.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, String>("valorUnitario"));
        jurCantidad.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, Integer>("cantidadExistencia"));
        jurCodAprovado.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, String>("codigoAprobado"));
        jurTemp.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, String>("tempRecomendada"));
        listaProductoRefrijerado = CrudRefrigerado.leerProductoRefrigerados();
        tablaProductosRefrijerados.setItems(listaProductosRefrijeradosObservable);
    }

    @FXML
    private TextField textCodigo;

    @FXML
    private TextField textNombre;

    @FXML
    private TextField textDescripcion;

    @FXML
    private TextField textValorU;

    @FXML
    private TextField textCantidad;

    @FXML
    private TextField textCodAprovado;

    @FXML
    private TextField textTemp;

    public void agregarProductoRefrijerado(ActionEvent event) {
        if (hayAlgo()) {
        try {
            String codigo = textCodigo.getText();
            String nombre = textNombre.getText();
            String descripcion = textDescripcion.getText();
            Float valorU = Float.parseFloat(textValorU.getText());
            int cantidad = Integer.parseInt(textCantidad.getText());
            String codigoAprovado = textCodAprovado.getText();
            String temp = textTemp.getText();
            vaciarCampos();
            ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado(codigo,nombre,descripcion,valorU,cantidad,codigoAprovado,temp);
            if (CrudRefrigerado.existeId(productoRefrigerado.getCodigo())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Datos ya ingresados");
                alert.showAndWait();
            }else {
                CrudRefrigerado.crearProductoRefri(productoRefrigerado);
                actualizar();
            }
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ingreso de datos invalido(s)");
            alert.showAndWait();
        }

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Llene todo");
            alert.showAndWait();
        }
    }

    public void modificacion(ActionEvent event) throws IOException {
        ProductoRefrigerado productoRefrigerado = this.tablaProductosRefrijerados.getSelectionModel().getSelectedItem();
        if (productoRefrigerado == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else{
            if (hayAlgo()){
                try {
                    String codigo = textCodigo.getText();
                    String nombre = textNombre.getText();
                    String descripcion = textDescripcion.getText();
                    Float valorU = Float.parseFloat(textValorU.getText());
                    int cantidad = Integer.parseInt(textCantidad.getText());
                    String codAprovado = textCodAprovado.getText();
                    String temp = textTemp.getText();
                    vaciarCampos();
                    ProductoRefrigerado productoRefrigeradoAux = new ProductoRefrigerado(codigo, nombre, descripcion, valorU, cantidad, codAprovado, temp);
                    boolean existNatural = listaProductoRefrijerado.contains(productoRefrigeradoAux);
                    if (existNatural){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("Datos iguales a otro Cliente");
                        alert.showAndWait();
                    }else{
                        CrudRefrigerado.actualizarProductoRefri(productoRefrigeradoAux, productoRefrigerado.getCodigo());
                        actualizar();
                        vaciarCampos();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Info");
                        alert.setContentText("Modificacion hecha");
                        alert.showAndWait();
                    }
                }catch (NumberFormatException e){
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Ingreso de datos invalido(s)");
                    alert.showAndWait();
                }

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Llene todo");
                alert.showAndWait();
            }
        }
    }

    public void actualizar(){
        listaProductoRefrijerado=CrudRefrigerado.leerProductoRefrigerados();
        listaProductosRefrijeradosObservable = FXCollections.observableList(listaProductoRefrijerado);
        tablaProductosRefrijerados.setItems(listaProductosRefrijeradosObservable);
    }

    public boolean hayAlgo(){
        boolean hayAlgo=false;
        if (!textCodigo.getText().isEmpty() && !textNombre.getText().isEmpty() && !textDescripcion.getText().isEmpty()
                && !textValorU.getText().isEmpty() && !textCantidad.getText().isEmpty() && !textCodAprovado.getText().isEmpty() && !textTemp.getText().isEmpty()){
            hayAlgo = true;
        }
        return hayAlgo;
    }

    public  void vaciarCampos(){
        textCodigo.setText("");textNombre.setText("");textDescripcion.setText("");
        textValorU.setText("");textCantidad.setText("");textCodAprovado.setText("");textTemp.setText("");
    }

    @FXML
    void switchScena1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void eliminarProductoRefrijerado(){
        ProductoRefrigerado productoRefrigerado = this.tablaProductosRefrijerados.getSelectionModel().getSelectedItem();
        if (productoRefrigerado == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else {
            CrudRefrigerado.eliminarProductoRefri(productoRefrigerado.getCodigo());
            vaciarCampos();
            actualizar();
        }
    }

    public void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void seleccionar(javafx.scene.input.MouseEvent mouseEvent) {
        ProductoRefrigerado productoRefrigerado = this.tablaProductosRefrijerados.getSelectionModel().getSelectedItem();
        if(productoRefrigerado != null){
            this.textCodigo.setText(productoRefrigerado.getCodigo());
            this.textNombre.setText(productoRefrigerado.getNombre());
            this.textDescripcion.setText(productoRefrigerado.getDescripcion());
            this.textValorU.setText(toString(productoRefrigerado.getValorUnitario()));
            this.textCantidad.setText(toString(productoRefrigerado.getCantidadExistencia()));
            this.textCodAprovado.setText(productoRefrigerado.getCodigoAprobado());
            this.textTemp.setText(productoRefrigerado.getTempRecomendada());
        }
    }
    private String toString(double valorUnitario) {
        return null;
    }

    private String toString(int cantidadExistencia){
        return null;
    }
}
