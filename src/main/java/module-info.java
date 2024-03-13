module com.example.structurelabs {
    requires javafx.controls;
    requires javafx.fxml;


    exports LabTabs;
    opens LabTabs to javafx.fxml;
}