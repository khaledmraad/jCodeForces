module com.example.jcodeforces {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;


    opens com.example.jcodeforces to javafx.fxml;
    exports com.example.jcodeforces;
}