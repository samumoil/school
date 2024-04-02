module test.viikko7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.viikko7 to javafx.fxml;
    exports test.viikko7;
}