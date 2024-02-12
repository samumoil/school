module com.example.testi1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testi1 to javafx.fxml;
    exports com.example.testi1;
}