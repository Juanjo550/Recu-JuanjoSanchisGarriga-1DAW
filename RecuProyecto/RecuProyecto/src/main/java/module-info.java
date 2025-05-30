module com.example.recuproyecto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.recuproyecto to javafx.fxml;
    exports com.example.recuproyecto;
}