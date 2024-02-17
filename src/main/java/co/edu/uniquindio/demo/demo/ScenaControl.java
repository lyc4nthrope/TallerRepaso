package co.edu.uniquindio.demo.demo;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class ScenaControl {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScena1(ActionEvent inicio){
        Parent root = FMXLLoader.Load(getClass().getResource("Scena1.fxml"))
    }

    public void switchScenaClientes(ActionEvent inicio){

    }
    public void switchScenaClienteNatural(ActionEvent inicio){

    }
    public void switchScenaClienteJuridico(ActionEvent inicio){

    }
    public void switchScenaProductos(ActionEvent inicio){

    }
    public void switchScenaProductoEnvasado(ActionEvent inicio){

    }
    public void switchScenaProductoPerecedero(ActionEvent inicio){

    }
    public void switchScenaProductoRefrigerado(ActionEvent inicio){

    }

}
