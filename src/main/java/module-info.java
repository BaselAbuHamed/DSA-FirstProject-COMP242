module com.example.projectone_1202397 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectone_1202397 to javafx.fxml;
    exports com.example.projectone_1202397;
}