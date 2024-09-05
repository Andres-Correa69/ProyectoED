module proyecto.colpensionex {
    requires javafx.controls;
    requires javafx.fxml;


    opens proyecto.colpensionex to javafx.fxml;
    exports proyecto.colpensionex;
}