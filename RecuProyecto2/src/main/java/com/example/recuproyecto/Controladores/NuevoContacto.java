package com.example.recuproyecto.Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NuevoContacto {

    @FXML
    private Button btAnadirContacto;

    @FXML
    private Button btVolver;

    @FXML
    private TextField tfApellido1;

    @FXML
    private TextField tfApellido2;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfTelefono;


    @FXML
    public void anadirNombre(ActionEvent actionEvent) {
    }

    @FXML
    public void anadirApellido1(ActionEvent actionEvent) {
    }

    @FXML
    public void anadirApellido2(ActionEvent actionEvent) {
    }

    @FXML
    public void anadirTelefono(ActionEvent actionEvent) {
    }

    @FXML
    public void anadirEmail(ActionEvent actionEvent) {
    }

    @FXML
    public void anadirContacto(ActionEvent actionEvent) {
    }

    @FXML
    public void Volver(ActionEvent actionEvent) {
        // Metodo que cierra la ventana actual al pulsar el botón de volver

        // Obtiene la ventana actual desde el botón y la cierra
        Stage stage = (Stage) btVolver.getScene().getWindow();
        stage.close(); // Esto también cierra la ventana actual
    }
}
