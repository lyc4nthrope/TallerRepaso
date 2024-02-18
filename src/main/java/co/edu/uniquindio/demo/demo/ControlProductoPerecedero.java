package co.edu.uniquindio.demo.demo;

import javafx.animation.AnimationTimer;
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
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ControlProductoPerecedero implements Initializable {
    ArrayList<ProductoPerecedero> listaProductoPerecedero = CrudPerecedero.leerProductoPerecedero();

    @FXML
    private TableColumn<ProductoPerecedero, String> jurCodigo;

    @FXML
    private TableColumn<ProductoPerecedero, String> jurNombre;

    @FXML
    private TableColumn<ProductoPerecedero, String> jurDescripcion;

    @FXML
    private TableColumn<ProductoPerecedero, String> jurValorU;

    @FXML
    private TableColumn<ProductoPerecedero, String> jurCantidad;

    @FXML
    private TableColumn<ProductoPerecedero, String> jurFechaVencimiento;

    @FXML
    private TableView<ProductoPerecedero> tablaProductosPerecederos;

    ObservableList<ProductoPerecedero> listaProductosPerecederosObservable = FXCollections.observableList(listaProductoPerecedero);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jurCodigo.setCellValueFactory(new PropertyValueFactory<ProductoPerecedero, String>("codigo"));
        jurNombre.setCellValueFactory(new PropertyValueFactory<ProductoPerecedero, String>("nombre"));
        jurDescripcion.setCellValueFactory(new PropertyValueFactory<ProductoPerecedero, String>("descripcion"));
        jurValorU.setCellValueFactory(new PropertyValueFactory<ProductoPerecedero, String>("valorUnitario"));
        jurCantidad.setCellValueFactory(new PropertyValueFactory<ProductoPerecedero, String>("Cantidad"));
        jurFechaVencimiento.setCellValueFactory(new PropertyValueFactory<ProductoPerecedero, String>("fechaVencimiento"));
        listaProductoPerecedero = CrudPerecedero.leerProductoPerecedero();
        tablaProductosPerecederos.setItems(listaProductosPerecederosObservable);
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
    private TextField textFechaVencimiento;

    public boolean hayAlgo(){
        boolean hayAlgo=false;
        if (!textCodigo.getText().isEmpty() && !textNombre.getText().isEmpty() && !textDescripcion.getText().isEmpty()
                && !textValorU.getText().isEmpty() && !textCantidad.getText().isEmpty() && !textFechaVencimiento.getText().isEmpty()){
            hayAlgo = true;
        }
        return hayAlgo;
    }

    public  void vaciarCampos(){
        textCodigo.setText("");textNombre.setText("");textDescripcion.setText("");
        textValorU.setText("");textCantidad.setText("");textFechaVencimiento.setText("");
    }

    void switchScena1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void eliminarProductoPerecedero(){
        ProductoPerecedero productoPerecedero = this.tablaProductosPerecederos.getSelectionModel().getSelectedItem();
        if (productoPerecedero == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else {

            actualizar();
            vaciarCampos();
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
        ProductoPerecedero productoPerecedero= this.tablaProductosPerecederos.getSelectionModel().getSelectedItem();
        if(productoPerecedero!=null){
            this.textCodigo.setText(productoPerecedero.getCodigo());
            this.textNombre.setText(productoPerecedero.getNombre());
            this.textDescripcion.setText(productoPerecedero.getDescripcion());
            this.textValorU.setText(productoPerecedero.getValorUnitario());
            this.textCantidad.setText(productoPerecedero.getCantidadExistencia());
            this.textFechaVencimiento.setText(productoPerecedero.getFechaVencimiento());
        }
    }
}
