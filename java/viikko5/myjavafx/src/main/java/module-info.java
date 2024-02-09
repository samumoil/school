module test.myjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens test.myjavafx to javafx.fxml;
    exports test.myjavafx;
}