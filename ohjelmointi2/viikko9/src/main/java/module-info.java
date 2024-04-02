module test.viikko9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.viikko9 to javafx.fxml;
    exports test.viikko9;
}