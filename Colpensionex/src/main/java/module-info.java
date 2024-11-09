module proyecto.colpensionex {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens proyecto.colpensionex to javafx.fxml;
    exports proyecto.colpensionex;
    exports proyecto.colpensionex.model;
    exports proyecto.colpensionex.repository.csv;
    exports proyecto.colpensionex.util;

}