package co.edu.uniquindio.demo.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage)throws IOException{
            /*Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            */
            //Scene scene = new Scene(fxmlLoader.load());

           FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scena1.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        /*Parent root = FXMLLoader.load(getClass().getResource("Scena1.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        */

    }


    public static void main(String[] args) {
        launch();
    }
}

/***
 *
 * metodo para verificar si esta todos los campos llenos en la ventana del crud
 *CrudNarutal natural = new CrudNatural;
 * if(!txt_nomble.equals("") && !txt_apellido.equals("") &&...){
 *     personanatural persona = new personanatural(txt_nombre....);
 *     natural.crearClienteNatu(persona);
 * }else{
 *     Joptio.Show.MensaggeDialog(null,"hay campos vacios o no se estan guardando los datos")
 * }
 */