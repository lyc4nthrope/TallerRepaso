package co.edu.uniquindio.demo.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ModificadorJuridico {
    ArrayList<PersonaJuridica> listaClientesJuridicos = CrudJuridico.leerClienteJuridico();


    public void volver(ActionEvent event) throws IOException {
        Parent rama = FXMLLoader.load(getClass().getResource("ScenaClienteJuridico.fxml"));
        Stage parte = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene esa = new Scene(rama);
        parte.setScene(esa);
        parte.show();
    }
    public void guardarModificiacion(){
        String nombreMod = txtNombreMod.getText();
        String apellidoMod = txtApellidoMod.getText();
        String direccionMod = txtDireccionMod.getText();
        String telefonoMod = txtTelefonoMod.getText();
        String nitMod = txtNITMod.getText();
        PersonaJuridica clienteJuridico = new PersonaJuridica(nombreMod, apellidoMod, idModificador.getText(), direccionMod, telefonoMod, nitMod);
        CrudJuridico.actualizarClienteJuri(idModificador.getText(), clienteJuridico);

    }
    @FXML
    private Button btnGuardarMod;

    @FXML
    private TextField txtApellidoMod;

    @FXML
    private TextField txtDireccionMod;

    @FXML
    private TextField txtNITMod;

    @FXML
    private TextField txtNombreMod;

    @FXML
    private TextField txtTelefonoMod;
    @FXML
    private Label idModificador;
    public void modificarJuridico(ActionEvent event) throws IOException {
        String id = JOptionPane.showInputDialog("Ingrese la ID de la persona a modificar");
        boolean existe=false;
        int indice=0;
        for (int i = 0; i < listaClientesJuridicos.size() && !existe; i++) {
            if(id.equalsIgnoreCase(listaClientesJuridicos.get(i).getIdentificacion())){
                existe=true;
                indice=i;
            }
        }
        if (existe){
            Parent rama = FXMLLoader.load(getClass().getResource("ModificarJuridico.fxml"));
            Stage parte = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene esa = new Scene(rama);
            parte.setScene(esa);
            parte.show();
            txtNombreMod.setText(listaClientesJuridicos.get(indice).getNombre());
            txtApellidoMod.setText(listaClientesJuridicos.get(indice).getApellidos());
            idModificador.setText(listaClientesJuridicos.get(indice).getIdentificacion());
            txtDireccionMod.setText(listaClientesJuridicos.get(indice).getDireccion());
            txtTelefonoMod.setText(listaClientesJuridicos.get(indice).getTelefono());
            txtNITMod.setText(listaClientesJuridicos.get(indice).getNit());
            guardarModificiacion();
            rama = FXMLLoader.load(getClass().getResource("ScenaClienteJuridico.fxml"));
            parte = (Stage)((Node)event.getSource()).getScene().getWindow();
            esa = new Scene(rama);
            parte.setScene(esa);
            parte.show();
        }else{
            JOptionPane.showMessageDialog(null, "No esta registrado nadie con esa identificacion");
        }
    }

}
