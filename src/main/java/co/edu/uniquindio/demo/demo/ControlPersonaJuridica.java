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

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;
public class ControlPersonaJuridica implements Initializable {
    ArrayList<PersonaJuridica> listaClientesJuridicos =CrudJuridico.leerClienteJuridico();
    @FXML
    private TableColumn<PersonaJuridica, String> jurApellido;

    @FXML
    private TableColumn<PersonaJuridica, String> jurDireccion;

    @FXML
    private TableColumn<PersonaJuridica, String> jurID;

    @FXML
    private TableColumn<PersonaJuridica, String> jurNit;

    @FXML
    private TableColumn<PersonaJuridica, String> jurNombre;

    @FXML
    private TableColumn<PersonaJuridica, String> jurTelefono;

    @FXML
    private TableView<PersonaJuridica> tablaJuridicos;

   ObservableList<PersonaJuridica> listaClientesJuridicosObservable = FXCollections.observableList(listaClientesJuridicos);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jurNombre.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("nombre"));
        jurApellido.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("apellidos"));
        jurID.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("identificacion"));
        jurDireccion.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("direccion"));
        jurTelefono.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("telefono"));
        jurNit.setCellValueFactory(new PropertyValueFactory<PersonaJuridica, String>("nit"));
        listaClientesJuridicos =CrudJuridico.leerClienteJuridico();
        tablaJuridicos.setItems(listaClientesJuridicosObservable);
    }

    public void agregarPersonaJuridica(ActionEvent event){
        if(hayAlgo()){
            String nombre = textNombre.getText();
            String apellido = textApellido.getText();
            String identificacion = textID.getText();
            String direccion = textDireccion.getText();
            String telefono = textTelefono.getText();
            String nit = textNit.getText();
            vaciarCampos();
            PersonaJuridica clienteJuridico = new PersonaJuridica(nombre,apellido,identificacion,direccion,telefono,nit);
            if(CrudJuridico.existeId(clienteJuridico.getIdentificacion())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Datos ya ingresados");
                alert.showAndWait();
            }else{
                CrudJuridico.crearClientesJuridico(clienteJuridico);
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

    public void modificacion(ActionEvent event) throws IOException {
            PersonaJuridica persona = this.tablaJuridicos.getSelectionModel().getSelectedItem();
            if (persona == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Debes seleccionar una persona");
                alert.showAndWait();
            }else {
                if(hayAlgo()){
                    String nombre = textNombre.getText();
                    String apellido = textApellido.getText();
                    String identificacion = textID.getText();
                    String direccion = textDireccion.getText();
                    String telefono = textTelefono.getText();
                    String nit = textNit.getText();
                    vaciarCampos();
                    PersonaJuridica clienteJuridicoAux = new PersonaJuridica(nombre,apellido,identificacion,direccion,telefono,nit);
                    boolean existJuridico = listaClientesJuridicos.contains(clienteJuridicoAux);
                    if (existJuridico){
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText(null);
                        alert.setTitle("Error");
                        alert.setContentText("Datos iguales a otro Cliente");
                        alert.showAndWait();
                    }else {
                        CrudJuridico.actualizarClienteJuri(clienteJuridicoAux,persona.getIdentificacion());
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

    public boolean hayAlgo(){
        boolean hayAlgo=false;
        if (!textApellido.getText().isEmpty() && !textNombre.getText().isEmpty() && !textID.getText().isEmpty()
                && !textTelefono.getText().isEmpty() && !textNit.getText().isEmpty() && !textDireccion.getText().isEmpty()){
        hayAlgo = true;
        }
        return hayAlgo;
    }
     public  void vaciarCampos(){
         textNombre.setText("");textApellido.setText("");textID.setText("");
         textDireccion.setText("");textTelefono.setText("");textNit.setText("");
     }
    @FXML
    private TextField textApellido;

    @FXML
    private TextField textDireccion;

    @FXML
    private TextField textID;

    @FXML
    private TextField textNit;

    @FXML
    private TextField textNombre;

    @FXML
    private TextField textTelefono;

    @FXML
    void switchScena1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void eliminarClienteJuridico(){
        PersonaJuridica persona = this.tablaJuridicos.getSelectionModel().getSelectedItem();
        if (persona == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else {
            CrudJuridico.eliminarClienteJuri(persona.getIdentificacion());
            actualizar();
            vaciarCampos();
        }
    }

    public void actualizar(){
        listaClientesJuridicos =CrudJuridico.leerClienteJuridico();
        listaClientesJuridicosObservable = FXCollections.observableList(listaClientesJuridicos);
        tablaJuridicos.setItems(listaClientesJuridicosObservable);
    }

    public void volver(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void seleccionar(javafx.scene.input.MouseEvent mouseEvent) {
        PersonaJuridica persona= this.tablaJuridicos.getSelectionModel().getSelectedItem();
        if(persona!=null){
            this.textNombre.setText(persona.getNombre());
            this.textApellido.setText(persona.getApellidos());
            this.textDireccion.setText(persona.getDireccion());
            this.textTelefono.setText(persona.getTelefono());
            this.textNit.setText(persona.getNit());
            this.textID.setText(persona.getIdentificacion());
        }
    }
}

