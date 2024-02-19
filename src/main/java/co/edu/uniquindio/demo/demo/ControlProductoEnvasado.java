package co.edu.uniquindio.demo.demo;

import javafx.beans.value.ObservableNumberValue;
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
import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class ControlProductoEnvasado implements Initializable {

    public TableView <ProductoEnvasado> listaJuridicos;
    @FXML
    private ComboBox<String> comboxPais;

    @FXML
    private TableColumn<ProductoEnvasado, Integer> jurCantidad;

    @FXML
    private TableColumn<ProductoEnvasado, String> jurCodigo;

    @FXML
    private TableColumn<ProductoEnvasado, String> jurDescripcion;

    @FXML
    private TableColumn<ProductoEnvasado, Date> jurFechaEnvase;

    @FXML
    private TableColumn<ProductoEnvasado, String> jurNombre;

    @FXML
    private TableColumn<ProductoEnvasado, Integer> jurPeso;
    @FXML
    private TableColumn<ProductoEnvasado, String> jurPais;

    @FXML
    private TableColumn<ProductoEnvasado, Float> jurValorUnidad;
    @FXML
    private TableView<ProductoEnvasado> tablaProdEnvasados;

    @FXML
    private TextField textCantExistencias;

    @FXML
    private TextField textCodigo;

    @FXML
    private TextField textDescripcion;

    @FXML
    private TextField textPesoEnvase;

    @FXML
    private TextField textValorUnidad;

    @FXML
    private DatePicker txtFechaEnvasado;

    @FXML
    private TextField txtNombre;

    ArrayList<ProductoEnvasado> productosEnvasados = CrudEnvasado.leerProductoEnvasado();
    ObservableList<ProductoEnvasado> productoEnvasadosObservable = FXCollections.observableList(productosEnvasados);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.jurNombre.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, String>("nombre"));
        this.jurCodigo.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, String>("codigo"));
        this.jurDescripcion.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, String>("descripcion"));
        this.jurValorUnidad.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, Float>("valorUnitario"));
        this.jurCantidad.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, Integer>("cantidadExistencia"));
        this.jurFechaEnvase.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, Date>("fechaEnvasado"));
        this.jurPeso.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, Integer>("pesoEnvase"));
        this.jurPais.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, String>("paisOrigen"));
        productosEnvasados =CrudEnvasado.leerProductoEnvasado();
        ObservableList<String> paises = FXCollections.observableArrayList("Colombia","Chile","Argentina","Ecuador","Peru");
        comboxPais.setItems(paises);
        if (tablaProdEnvasados!=null){tablaProdEnvasados.setItems(productoEnvasadosObservable);}
    }
    public void seleccionar(javafx.scene.input.MouseEvent mouseEvent) {
        ProductoEnvasado envasado= this.tablaProdEnvasados.getSelectionModel().getSelectedItem();
        if(envasado!=null){
            this.textCodigo.setText(envasado.getCodigo());
            this.txtNombre.setText(envasado.getNombre());
            this.textDescripcion.setText(envasado.getDescripcion());
            this.textValorUnidad.setText(envasado.getValorUnitario().toString());
            this.textCantExistencias.setText(String.valueOf(envasado.getCantidadExistencia()));
            this.txtFechaEnvasado.setValue(envasado.getFechaEnvasado());
            this.textPesoEnvase.setText(String.valueOf(envasado.getPesoEnvase()));
            this.comboxPais.setValue(envasado.getPaisOrigen());
        }
    }
    public void agregarProductoEnvasado(ActionEvent event){
        if(hayAlgo()){
            String codigo = textCodigo.getText();
            String nombre = txtNombre.getText();
            String descripcion = textDescripcion.getText();
            Float valorUnidad = Float.valueOf(textValorUnidad.getText());
            Integer cantExistencias = Integer.valueOf(textCantExistencias.getText());
            LocalDate fechaEnvasado = txtFechaEnvasado.getValue();
            Integer peso = Integer.valueOf(textPesoEnvase.getText());
            String pais = comboxPais.getValue();
            vaciarCampos();
            ProductoEnvasado productoEnvasado = new ProductoEnvasado(codigo,nombre,descripcion,valorUnidad,cantExistencias,fechaEnvasado,peso,pais);
            if(CrudEnvasado.existeCodigo(productoEnvasado.getCodigo())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Producto ya registrado");
                alert.showAndWait();
            }else{
                CrudEnvasado.crearProductoEnvasado(productoEnvasado);
                actualizar();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Llene todo");
            alert.showAndWait();
        }

    }

    private void vaciarCampos() {
        txtFechaEnvasado.setValue(null);
        txtNombre.setText("");
        textValorUnidad.setText("");
        textDescripcion.setText("");
        textCantExistencias.setText("");
        textCodigo.setText("");
        textPesoEnvase.setText("");
        comboxPais.setValue("");
    }

    private boolean hayAlgo() {
        boolean hayAlgo=false;
        if (!txtNombre.getText().isEmpty()&&!textCodigo.getText().isEmpty()&&!textDescripcion.getText().isEmpty()
                &&!textValorUnidad.getText().isEmpty()&&!textPesoEnvase.getText().isEmpty()&&!textCantExistencias.getText().isEmpty()
        && !(txtFechaEnvasado.getChronology()==null)&&!comboxPais.getValue().isEmpty()){
            hayAlgo=true;
        }
        return hayAlgo;
    }

    public void modificacion(ActionEvent event) throws IOException {
        ProductoEnvasado productoEnvasado = this.tablaProdEnvasados.getSelectionModel().getSelectedItem();
        if (productoEnvasado == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else {
            if(hayAlgo()){
                String codigo = textCodigo.getText();
                String nombre = txtNombre.getText();
                String descripcion = textDescripcion.getText();
                Float valorUnidad = Float.valueOf(textValorUnidad.getText());
                Integer cantExistencias = Integer.valueOf(textCantExistencias.getText());
                LocalDate fechaEnvasado = txtFechaEnvasado.getValue();
                Integer peso = Integer.valueOf(textPesoEnvase.getText());
                String pais = comboxPais.getValue();
                vaciarCampos();
                ProductoEnvasado auxProductoEnvasado = new ProductoEnvasado(codigo,nombre,descripcion,valorUnidad,cantExistencias,fechaEnvasado,peso,pais);
                boolean existProd = productosEnvasados.contains(auxProductoEnvasado);
                if (existProd){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Datos iguales a otro producto");
                    alert.showAndWait();
                }else {
                    CrudEnvasado.actualizarProductoEn(auxProductoEnvasado, productoEnvasado.getCodigo());
                    actualizar();
                    vaciarCampos();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Info");
                    alert.setContentText("Modificacion hecha");
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
    public void eliminarProductoEnvasado(){
        ProductoEnvasado productoEnvasado = this.tablaProdEnvasados.getSelectionModel().getSelectedItem();
        if (productoEnvasado == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else {
            CrudJuridico.eliminarClienteJuri(productoEnvasado.getCodigo());
            actualizar();
            vaciarCampos();
        }
    }

    @FXML
    void switchScena1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void actualizar(){
        productosEnvasados =CrudEnvasado.leerProductoEnvasado();
        productoEnvasadosObservable = FXCollections.observableList(productosEnvasados);
        tablaProdEnvasados.setItems(productoEnvasadosObservable);
    }
}
