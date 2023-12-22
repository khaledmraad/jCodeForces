module com.example.jcodeforces {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jcodeforces to javafx.fxml;
    exports com.example.jcodeforces;
}