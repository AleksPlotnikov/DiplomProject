module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports VacantList;
    opens VacantList to javafx.fxml;
    exports WriteAndWorkingClasses;
    opens WriteAndWorkingClasses to javafx.fxml;
}