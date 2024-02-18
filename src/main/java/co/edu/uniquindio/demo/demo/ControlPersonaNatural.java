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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControlPersonaNatural implements Initializable{

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
    private TableColumn<PersonaNatural, String>jurFechaNacimiento;

    @FXML
    private TableView<PersonaNatural> tablaNatural;

    ObservableList<PersonaNatural> listaClientesNaturalesObservable = FXCollections.observableList(listaClientesNaturales);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        jurNombre.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("nombre"));
        jurApellido.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("apellidos"));
        jurId.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("identificacion"));
        jurDireccion.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("direccion"));
        jurTelefono.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("telefono"));
        jurEmail.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("Email"));
        jurFechaNacimiento.setCellValueFactory(new PropertyValueFactory<PersonaNatural, String>("FechaNacimiento"));
        listaClientesNaturales =CrudNatural.leerClienteNatu();
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

    public void agregarPersonaNatural(ActionEvent event){
        String nombre = textNombre.getText();
        String apellido = textApellido.getText();
        String identificacion = textID.getText();
        String direccion = textDireccion.getText();
        String telefono = textTelefono.getText();
        String email = textEmail.getText();
        String fechaNacimento = textFechaNacimiento.getText();
        textNombre.setText("");textApellido.setText("");textID.setText("");
        textDireccion.setText("");textTelefono.setText("");textEmail.setText("");textFechaNacimiento.setText("");
        PersonaNatural clienteNatural = new PersonaNatural(nombre, apellido, identificacion, direccion, telefono, email, fechaNacimento);


        }











}
