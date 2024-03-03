module test.viikko8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.viikko8 to javafx.fxml;
    exports test.viikko8;
}