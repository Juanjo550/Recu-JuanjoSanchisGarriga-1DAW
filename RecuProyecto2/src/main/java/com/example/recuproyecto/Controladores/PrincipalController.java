package com.example.recuproyecto.Controladores;

import com.example.recuproyecto.DAO.ContactoDAO;
import com.example.recuproyecto.POJO.Contacto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PrincipalController {
    private static Stage stage1;
    private static Scene scene;
    private static Stage stage2;
    private static Stage stage3;

    @FXML
    private TextField tfNombreBusqueda;

    @FXML
    private TextField tfEmailBusqueda;

    @FXML
    private TextArea taUsuarioEncontrado;

    @FXML
    public void nuevoContacto(ActionEvent actionEvent) throws IOException {
        stage1 = new Stage();
        stage1.initModality(Modality.WINDOW_MODAL);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/recuproyecto/Nuevo-contacto.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);

        Node a = ((Node) actionEvent.getSource());
        stage1.initOwner(a.getScene().getWindow());

        stage1.setScene(scene3);
        stage1.show();
    }

    @FXML
    public void editarContacto(ActionEvent actionEvent) throws IOException {
        stage2 = new Stage();
        stage2.initModality(Modality.WINDOW_MODAL);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/recuproyecto/Editar-contacto.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);

        Node a = ((Node) actionEvent.getSource());
        stage2.initOwner(a.getScene().getWindow());

        stage2.setScene(scene3);
        stage2.show();
    }

    @FXML
    public void borrarContacto(ActionEvent actionEvent) throws IOException {
        stage3 = new Stage();
        stage3.initModality(Modality.WINDOW_MODAL);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/recuproyecto/Eliminar-contacto.fxml"));
        Scene scene3 = new Scene(fxmlLoader.load(), 900, 600);

        Node a = ((Node) actionEvent.getSource());
        stage3.initOwner(a.getScene().getWindow());

        stage3.setScene(scene3);
        stage3.show();
    }

    @FXML
    public void buscarNombre(ActionEvent actionEvent) {
        String nombre = tfNombreBusqueda.getText().trim();
        List<Contacto> contactos = new ContactoDAO().obtenerPorNombre(nombre);

        if (!contactos.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Contacto c : contactos) {
                sb.append(c.toString()).append("\n----------------\n");
            }
            taUsuarioEncontrado.setText(sb.toString());
        } else {
            taUsuarioEncontrado.setText("No se encontro nombre.");
        }
    }

    @FXML
    public void buscarEmail(ActionEvent actionEvent) {
        String email = tfEmailBusqueda.getText().trim();
        Contacto contacto = new ContactoDAO().obtenerPorEmail(email);

        if (contacto != null) {
            taUsuarioEncontrado.setText(contacto.toString());
        } else {
            taUsuarioEncontrado.setText("No se encontro email.");
        }
    }

    @FXML
    public void ponNombre(ActionEvent actionEvent) {
    }

    @FXML
    public void ponEmail(ActionEvent actionEvent) {
    }
}
