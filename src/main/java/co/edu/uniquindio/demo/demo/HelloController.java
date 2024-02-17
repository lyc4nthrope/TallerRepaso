package co.edu.uniquindio.demo.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TableColumn<?, ?> jurApellido;

    @FXML
    private TableColumn<?, ?> jurDireccion;

    @FXML
    private TableColumn<?, ?> jurID;

    @FXML
    private TableColumn<?, ?> jurNit;

    @FXML
    private TableColumn<?, ?> jurNombre;

    @FXML
    private TableColumn<?, ?> jurTelefono;

    @FXML
    private TableView<?> listaJuridicos;

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
}