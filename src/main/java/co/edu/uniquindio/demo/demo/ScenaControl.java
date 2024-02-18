package co.edu.uniquindio.demo.demo;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ScenaControl  {

    private Stage stage;
    private Scene scene;
    private Parent root;



    public void switchScena1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchScenaClientes(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("ScenaClientes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchScenaClienteNatural(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("ScenaClienteNatural.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchScenaClienteJuridico(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("ScenaClienteJuridico.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchScenaProductos(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("ScenaProductos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchScenaProductoEnvasado(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ScenaProductoEnvasado.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchScenaProductoPerecedero(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ScenaProductoPerecedero.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchScenaProductoRefrigerado(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ScenaProductoRefrigerado.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
