module test.viikko6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.viikko6 to javafx.fxml;
    exports test.viikko6;
}