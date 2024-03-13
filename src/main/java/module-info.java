module com.example.structurelabs {
    requires javafx.controls;
    requires javafx.fxml;


    exports Labs;
    opens Labs to javafx.fxml;
}