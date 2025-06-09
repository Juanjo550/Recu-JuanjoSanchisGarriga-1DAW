package com.example.recuproyecto.Controladores;

import com.example.recuproyecto.DAO.ContactoDAO;
import com.example.recuproyecto.POJO.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrincipalController {
    private static Stage stage1;
    private static Scene scene;
    private static Stage stage2;
    private static Stage stage3;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblApellido1;

    @FXML
    private Label lblApellido2;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblEmail;


    @FXML
    private TableView<Contacto> tablaContactos;

    @FXML
    private TableColumn<Contacto, String> tcMostrarNombre;

    @FXML
    private TableColumn<Contacto, String> tcMostrarApellido1;

    @FXML
    private TextField tfNombre;  // Cambiado de tfNombreBusqueda

    @FXML
    private TextField tfEmail;   // Cambiado de tfEmailBusqueda

    @FXML
    private TextArea taUsuarioEncontrado;

    @FXML
    public void initialize() {
        ContactoDAO contactoDAO = new ContactoDAO();
        ArrayList<Contacto> listContacto = new ArrayList<>();
        listContacto.addAll(contactoDAO.obtenerTodos());
        ObservableList<Contacto> listContactos = FXCollections.observableArrayList(listContacto);

        tcMostrarNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcMostrarApellido1.setCellValueFactory(new PropertyValueFactory<>("apellido1"));

        tablaContactos.setItems(listContactos);

        tablaContactos.getSelectionModel().selectedItemProperty().addListener((observar, anteriorContacto, nuevoContacto) -> {
            if (nuevoContacto != null) {
                lblNombre.setText(nuevoContacto.getNombre());
                lblApellido1.setText(nuevoContacto.getApellido1());
                lblApellido2.setText(nuevoContacto.getApellido2());
                lblEmail.setText(nuevoContacto.getEmail());
                lblTelefono.setText(String.valueOf(nuevoContacto.getTelefono()));
            }else {
                lblNombre.setText("");
                lblApellido1.setText("");
                lblApellido2.setText("");
                lblEmail.setText("");
                lblTelefono.setText("");
            }
        });
    }

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
        String nombre = tfNombre.getText().trim();  // Aquí usamos tfNombre
        List<Contacto> contactos = new ContactoDAO().obtenerPorNombre(nombre);

        if (!contactos.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Contacto c : contactos) {
                sb.append(c.toString()).append("\n----------------\n");
            }
            taUsuarioEncontrado.setText(sb.toString());
        } else {
            taUsuarioEncontrado.setText("No se encontró nombre.");
        }
    }

    @FXML
    public void buscarEmail(ActionEvent actionEvent) {
        String email = tfEmail.getText().trim();  // Aquí usamos tfEmail
        Contacto contacto = new ContactoDAO().obtenerPorEmail(email);

        if (contacto != null) {
            taUsuarioEncontrado.setText(contacto.toString());
        } else {
            taUsuarioEncontrado.setText("No se encontró email.");
        }
    }

    @FXML
    public void ponNombre(ActionEvent actionEvent) {
        //pa que no de error
    }

    @FXML
    public void ponEmail(ActionEvent actionEvent) {
        //pa que no de error
    }
}
