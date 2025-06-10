package com.example.recuproyecto.Controladores;

import com.example.recuproyecto.DAO.ContactoDAO;
import com.example.recuproyecto.POJO.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

    private final ContactoDAO contactoDAO = new ContactoDAO();

    @FXML
    public void anadirContacto(ActionEvent actionEvent) {
        String nombre = tfNombre.getText();
        String apellido1 = tfApellido1.getText();
        String apellido2 = tfApellido2.getText();
        String email = tfEmail.getText();
        String telefonoStr = tfTelefono.getText();

        if (nombre.isEmpty() || apellido1.isEmpty() || email.isEmpty() || telefonoStr.isEmpty()) {
            mostrarAlerta("Campos vacios", "Rellena los campos.");
            return;
        }

        int telefono;

        try {
            telefono = Integer.parseInt(telefonoStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("Formato incorrecto", "Solo del 0 al 9.");
            return;
        }

        if (contactoDAO.obtenerPorEmail(email) != null) {
            mostrarAlerta("Email duplicado", "Ya existe.");
            return;
        }

        for (Contacto c : contactoDAO.obtenerTodos()) {
            if (c.getTelefono() == telefono) {
                mostrarAlerta("Telefono duplicado", "Ya existe.");
                return;
            }
        }

        if (!telefonoStr.matches("6\\d{8}")) {
            mostrarAlerta(Alert.AlertType.ERROR, "Teléfono inválido", "Debe empezar por 6 y tener 9 dígitos.");
            return;
        }

        Contacto nuevo = new Contacto(0, nombre, apellido1, apellido2, telefono, email);
        contactoDAO.insertar(nuevo);

        mostrarAlerta("Contacto anadido", "Anadido correctamente.");

        // Limpiar campos
        tfNombre.clear();
        tfApellido1.clear();
        tfApellido2.clear();
        tfTelefono.clear();
        tfEmail.clear();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
    

    @FXML
    public void Volver(ActionEvent actionEvent) {
        Stage stage = (Stage) btVolver.getScene().getWindow();
        stage.close();
    }

    public void anadirNombre(ActionEvent actionEvent) {
    }

    public void anadirEmail(ActionEvent actionEvent) {
    }

    public void anadirTelefono(ActionEvent actionEvent) {
    }

    public void anadirApellido2(ActionEvent actionEvent) {
    }

    public void anadirApellido1(ActionEvent actionEvent) {
    }
}
