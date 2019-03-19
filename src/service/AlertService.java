package service;

import javafx.scene.control.Alert;
import javafx.stage.Window;


public class AlertService {
    public static void showAlert(
            Alert.AlertType alertType,
            String title,
            String message,
            Window window) {

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.initOwner(window);
        alert.setHeaderText(null);
        // alert.setHeaderText("Header!");
        alert.show();

    }

}
