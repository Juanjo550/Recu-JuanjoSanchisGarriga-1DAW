package com.example.recuproyecto.Controladores;

import com.example.recuproyecto.DAO.ContactoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EliminarContacto {

    @FXML
    private Button btEliminarContacto;

    @FXML
    private Button btVolver;

    @FXML
    private TextField tfTelefono;

    private final ContactoDAO contactoDAO = new ContactoDAO();

    @FXML
    public void anadirTelefono(ActionEvent actionEvent) {
        // Puedes dejarlo vacío si no se usa
    }

    @FXML
    public void Volver() {
        Stage stage = (Stage) btVolver.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void eliminarContacto(ActionEvent actionEvent) {
        String telefonoTexto = tfTelefono.getText().trim();

        if (!telefonoTexto.matches("6\\d{8}")) {
            mostrarAlerta(Alert.AlertType.ERROR, "Formato inválido", "El telefono debe tener 9 dígitos y empezar por 6.");
            return;
        }

        int telefono = Integer.parseInt(telefonoTexto);

        boolean existe = contactoDAO.obtenerTodos()
                .stream()
                .anyMatch(c -> c.getTelefono() == telefono);

        if (!existe) {
            mostrarAlerta(Alert.AlertType.WARNING, "Contacto no encontrado", "No se ha encontrado un contacto.");
            return;
        }


        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Estás seguro de que quieres eliminar este contacto?");
        confirmacion.setContentText("Teléfono: " + telefono);

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                boolean eliminado = contactoDAO.eliminarPorTelefono(telefono);
                if (eliminado) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "El contacto fue eliminado correctamente.");
                    tfTelefono.clear();
                } else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo eliminar el contacto.");
                }
            }
        });
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
