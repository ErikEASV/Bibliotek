module com.example.bibliotek {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.naming;   // nødvendig: EK 4.11.22

    opens com.example.bibliotek to javafx.fxml;
    exports com.example.bibliotek;
}