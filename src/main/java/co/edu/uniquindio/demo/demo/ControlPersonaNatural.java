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

public class ControlPersonaNatural implements Initializable {

    ArrayList<PersonaNatural> listaClientesNaturales = CrudNatural.leerClienteNatu();
    @FXML
    private TableColumn<PersonaNatural, String> jurNombre;

    @FXML
    private TableColumn<PersonaNatural, String> jurApellido;

    @FXML
    private TableColumn<PersonaNatural, String> jurId;

    @FXML
    private TableColumn<PersonaNatural, String> jurDireccion;

    @FXML
    private TableColumn<PersonaNatural, String> jurTelefono;

    @FXML
    private TableColumn<PersonaNatural, String> jurEmail;

    @FXML
    private TableColumn<PersonaNatural, String> jurFechaNacimiento;

    @FXML
    private TableView<PersonaNatural> tablaNatural;

    ObservableList<PersonaNatural> listaClientesNaturalesObservable = FXCollections.observableList(listaClientesNaturales);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jurNombre.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("nombre"));
        jurApellido.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("apellidos"));
        jurId.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("identificacion"));
        jurDireccion.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("direccion"));
        jurTelefono.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("telefono"));
        jurEmail.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("Email"));
        jurFechaNacimiento.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("FechaNacimiento"));
        listaClientesNaturales = CrudNatural.leerClienteNatu();
        tablaNatural.setItems(listaClientesNaturalesObservable);
    }

    @FXML
    private TextField textNombre;

    @FXML
    private TextField textApellido;

    @FXML
    private TextField textID;

    @FXML
    private TextField textDireccion;

    @FXML
    private TextField textTelefono;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textFechaNacimiento;

    public void agregarPersonaNatural(ActionEvent event) {
        if (hayAlgo()) {
            String nombre = textNombre.getText();
            String apellido = textApellido.getText();
            String identificacion = textID.getText();
            String direccion = textDireccion.getText();
            String telefono = textTelefono.getText();
            String email = textEmail.getText();
            String fechaNacimento = textFechaNacimiento.getText();
            vaciarCampos();
            PersonaNatural clienteNatural = new PersonaNatural(nombre, apellido, identificacion, direccion, telefono, email, fechaNacimento);
            if (CrudNatural.existeId(clienteNatural.getIdentificacion())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Datos ya ingresados");
                alert.showAndWait();
            }else {
                CrudNatural.crearClienteNatu(clienteNatural);
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

    public void modificacion(ActionEvent event) throws IOException{
        PersonaNatural persona = this.tablaNatural.getSelectionModel().getSelectedItem();
        if (persona == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else{
            if (hayAlgo()){
                String nombre = textNombre.getText();
                String apellido = textApellido.getText();
                String identificacion = textID.getText();
                String direccion = textDireccion.getText();
                String telefono = textTelefono.getText();
                String email = textEmail.getText();
                String fechaNacimiento = textFechaNacimiento.getText();
                vaciarCampos();
                PersonaNatural clienteNaturalAux = new PersonaNatural(nombre, apellido, identificacion, direccion, telefono, email, fechaNacimiento);
                boolean existNatural = listaClientesNaturales.contains(clienteNaturalAux);
                if (existNatural){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("Datos iguales a otro Cliente");
                    alert.showAndWait();
                }else{
                    CrudNatural.actualizarClienteNatu(clienteNaturalAux,persona.getIdentificacion());
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
                && !textTelefono.getText().isEmpty() && !textEmail.getText().isEmpty() && !textDireccion.getText().isEmpty() && !textFechaNacimiento.getText().isEmpty()){
            hayAlgo = true;
        }
        return hayAlgo;
    }

    public  void vaciarCampos(){
        textNombre.setText("");textApellido.setText("");textID.setText("");
        textDireccion.setText("");textTelefono.setText("");textEmail.setText("");textFechaNacimiento.setText("");
    }

    public void actualizar(){
        listaClientesNaturales =CrudNatural.leerClienteNatu();
        listaClientesNaturalesObservable = FXCollections.observableList(listaClientesNaturales);
        tablaNatural.setItems(listaClientesNaturalesObservable);
    }
    void switchScena1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void eliminarClienteNatural(){
        PersonaNatural persona = this.tablaNatural.getSelectionModel().getSelectedItem();
        if (persona == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        }else {
            CrudNatural.eliminarClienteNatu(persona.getIdentificacion());
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
        PersonaNatural persona= this.tablaNatural.getSelectionModel().getSelectedItem();
        if(persona!=null){
            this.textNombre.setText(persona.getNombre());
            this.textApellido.setText(persona.getApellidos());
            this.textID.setText(persona.getIdentificacion());
            this.textDireccion.setText(persona.getDireccion());
            this.textTelefono.setText(persona.getTelefono());
            this.textEmail.setText(persona.getEmail());
            this.textFechaNacimiento.setText(persona.getFechaNacimiento());
        }
    }
}
