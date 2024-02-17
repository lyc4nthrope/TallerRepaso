package co.edu.uniquindio.demo.demo;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class ScenaControl {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScena1(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("Scena1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }

    public void switchScenaClientes(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("ScenaClientes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }
    public void switchScenaClienteNatural(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("ScenaClienteNatural.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }
    public void switchScenaClienteJuridico(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("ScenaClienteJuridico.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }
    public void switchScenaProductos(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("ScenaProductos.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }
    public void switchScenaProductoEnvasado(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("ScenaProductoEnvasado.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }
    public void switchScenaProductoPerecedero(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("ScenaProductoPerecedero.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }
    public void switchScenaProductoRefrigerado(ActionEvent undir){
        root = FMXLLoader.Load(getClass().getResource("ScenaProductoRefrigerado.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show;
    }

}
