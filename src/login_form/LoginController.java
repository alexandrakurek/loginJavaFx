package login_form;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import registration_form.model.UserDao;
import service.AlertService;

public class LoginController {

    public TextField usernameField;
    public TextField passwordField;


    public void handleLogin(ActionEvent actionEvent) {
        if(UserDao.login(
                usernameField.getText(), passwordField.getText())){
            AlertService.showAlert(
                    Alert.AlertType.INFORMATION,
                    "Login successful",
                    "You have sucessfully loggied into aplication",
                    usernameField.getScene().getWindow());
        } else {
            AlertService.showAlert(
                    Alert.AlertType.ERROR,
                "Login failed",
                "You've passed invalid credetials",
                usernameField.getScene().getWindow());



        }



    }
}
