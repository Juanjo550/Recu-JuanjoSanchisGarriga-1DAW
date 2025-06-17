module com.example.recuproyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.desktop;

    exports com.example.recuproyecto.Controladores;

    opens com.example.recuproyecto.Controladores to javafx.fxml;
    opens com.example.recuproyecto.POJO to javafx.base;
}


