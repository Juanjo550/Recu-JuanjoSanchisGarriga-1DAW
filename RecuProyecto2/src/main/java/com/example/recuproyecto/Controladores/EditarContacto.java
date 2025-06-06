package com.example.recuproyecto.Controladores;

import com.example.recuproyecto.DAO.ContactoDAO;
import com.example.recuproyecto.POJO.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EditarContacto {

    @FXML
    private Button btEditarContacto;

    @FXML
    private Button btVolver1;

    @FXML
    private Button btValidarEmail;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfApellido1;

    @FXML
    private TextField tfApellido2;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfTelefono;

    private final ContactoDAO contactoDAO = new ContactoDAO();
    private Contacto contactoActual = null;

    @FXML
    public void validarEmail(ActionEvent actionEvent) {
        String email = tfEmail.getText().trim();

        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            mostrarAlerta(Alert.AlertType.ERROR, "Email inválido", "Introduce un email con formato correcto.");
            return;
        }

        contactoActual = contactoDAO.obtenerPorEmail(email);

        if (contactoActual == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "No encontrado", "No existe ningún contacto con ese email.");
        } else {
            tfNombre.setText(contactoActual.getNombre());
            tfApellido1.setText(contactoActual.getApellido1());
            tfApellido2.setText(contactoActual.getApellido2());
            tfTelefono.setText(String.valueOf(contactoActual.getTelefono()));
            mostrarAlerta(Alert.AlertType.INFORMATION, "Contacto encontrado", "Puedes editar los datos y pulsar 'Editar Contacto'.");
        }
    }

    @FXML
    public void editarContacto(ActionEvent actionEvent) {
        if (contactoActual == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Validación requerida", "Primero debes validar un email válido.");
            return;
        }

        String nombre = tfNombre.getText().trim();
        String apellido1 = tfApellido1.getText().trim();
        String apellido2 = tfApellido2.getText().trim();
        String telefonoStr = tfTelefono.getText().trim();

        if (nombre.isEmpty() || apellido1.isEmpty() || telefonoStr.isEmpty()) {
            mostrarAlerta(Alert.AlertType.ERROR, "Campos vacíos", "Nombre, primer apellido y teléfono son obligatorios.");
            return;
        }

        if (!telefonoStr.matches("6\\d{8}")) {
            mostrarAlerta(Alert.AlertType.ERROR, "Teléfono inválido", "Debe empezar por 6 y tener 9 dígitos.");
            return;
        }

        // Actualizamos el objeto y la base de datos
        contactoActual.setNombre(nombre);
        contactoActual.setApellido1(apellido1);
        contactoActual.setApellido2(apellido2);
        contactoActual.setTelefono(Integer.parseInt(telefonoStr));

        boolean actualizado = contactoDAO.actualizar(contactoActual);

        if (actualizado) {
            mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "El contacto ha sido actualizado.");
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo actualizar el contacto.");
        }
    }

    @FXML
    public void Volver(ActionEvent actionEvent) {
        Stage stage = (Stage) btVolver1.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public void editarNombre(ActionEvent actionEvent) {
    }

    public void editarApellido1(ActionEvent actionEvent) {
    }

    public void editarApellido2(ActionEvent actionEvent) {
    }

    public void editarrTelefono(ActionEvent actionEvent) {
    }
}
