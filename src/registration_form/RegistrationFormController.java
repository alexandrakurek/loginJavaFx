package registration_form;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import registration_form.model.User;
import registration_form.model.UserDao;
import service.AlertService;

import java.io.IOException;


public class RegistrationFormController {

    private static final String EMAIL_REGEX = ".+\\@.+\\..+";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @FXML
    public TextField usernameField;
    public TextField surnameField;
    public TextField nameField;
    public TextField emailField;
    public TextField passwordField;
    public TextField passwordConfirmationField;

    public Label usernameErrorLabel;
    public Label surnameErrorLabel;
    public Label nameErrorLabel;
    public Label emailErrorLabel;
    public Label passwordErrorLabel;
    public Label passwordConfirmationErrorLabel;

    public ImageView usernameOkIcon;

    public void initialize() {
        usernameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                //walidacje cz username jest poprawny
                usernameOkIcon.setVisible(true);
            }
        });


//        usernameField.textProperty()
//                .addListener((observable, oldValue, newValue) ->{
//                    System.out.println("old value:" + " " +  oldValue);
//                    System.out.println("new value:" + " " +  newValue );
//                });


        // listenery sluza do zmian wartosci w aplikacji  - zamiast tego u gory, czyszczenie dla kazdego z tych pol
        usernameField.textProperty()
                .addListener(observable -> usernameErrorLabel.setVisible(false));

        nameField.textProperty()
                .addListener(observable -> nameErrorLabel.setVisible(false));

        surnameField.textProperty()
                .addListener(observable -> surnameErrorLabel.setVisible(false));

        emailField.textProperty()
                .addListener(observable -> emailErrorLabel.setVisible(false));

        passwordField.textProperty()
                .addListener(observable -> passwordErrorLabel.setVisible(false));

        passwordConfirmationField.textProperty()
                .addListener(observable -> passwordConfirmationErrorLabel.setVisible(false));
    }


    public void registerHandler(ActionEvent actionevent) {
        //        System.out.println("button click handler");
//        System.out.println(usernameField.getText());


        boolean valid = true;

        // CZY SA PUSTE POLA
        //username
        if (usernameField.getText().isEmpty()) {
            String message = "Username cannot to be empty";
            usernameErrorLabel.setText(message);
            usernameErrorLabel.setVisible(true);
            valid = false;
        } else if (UserDao.existByUsername(usernameField.getText())) {
            usernameErrorLabel.setText("Username already exists");
            usernameErrorLabel.setVisible(true);
            valid = false;
        }
        // name
        if (nameField.getText().isEmpty()) {
            String message = "Name cannot to be empty";
            nameErrorLabel.setText(message);
            nameErrorLabel.setVisible(true);
            valid = false;
        }

        // surname
        if (surnameField.getText().isEmpty()) {
            String message = "Surname cannot to be empty";
            surnameErrorLabel.setText(message);
            surnameErrorLabel.setVisible(true);
            valid = false;
        }

        // email
        if (emailField.getText().isEmpty()) {
            String message = "Email cannto to be empty";
            emailErrorLabel.setText(message);
            emailErrorLabel.setVisible(true);
            valid = false;
        } else if (!emailField.getText().matches(EMAIL_REGEX)) {
            emailErrorLabel.setText("Email has wrong format");
            emailErrorLabel.setVisible(true);
            valid = false;
        }

        // password
        if (passwordField.getText().isEmpty()) {
            String message = "Password cannot to be empty";
            passwordErrorLabel.setText(message);
            passwordErrorLabel.setVisible(true);
            valid = false;
        } else if (passwordField.getText().matches(PASSWORD_REGEX)) {
            passwordErrorLabel.setText("Password is too simple");
            passwordErrorLabel.setVisible(true);
            valid = false;


        }

        //passwordConfirmation
        if (passwordConfirmationField.getText().isEmpty()) {
            String message = "Password confirmation cannot to be empty";
            passwordConfirmationErrorLabel.setText(message);
            passwordConfirmationErrorLabel.setVisible(true);
            valid = false;
        }


//        boolean valid = isNotEmpty(usernameField, true, usernameErrorLabel);
//
//        valid = isNotEmpty(nameField,valid, nameErrorLabel) && valid ;
//        valid = isNotEmpty(surnameField,valid,surnameErrorLabel) && valid ;
//        valid = isNotEmpty(emailField,valid, emailErrorLabel) && valid;
//        valid = isNotEmpty(passwordField,valid, passwordErrorLabel) & valid;
//        valid = isNotEmpty(passwordConfirmationField,valid, passwordConfirmationErrorLabel) && valid;

        if (valid) {
            UserDao.add(new User(
                    usernameField.getText(),
                    nameField.getText(),
                    surnameField.getText(),
                    emailField.getText(),
                    passwordField.getText()));

            AlertService.showAlert(
                    Alert.AlertType.INFORMATION,
                    "Registration successful",
                    "Your registration is successful",
                    usernameField.getScene().getWindow());

            try {
                Stage stage = new Stage(); // musimy sami stworzyc stage
                Parent newWindow = FXMLLoader.load(getClass().getResource("../vbox/vbox.fxml"));
                stage.setScene(new Scene(newWindow, 600,400));
                stage.setTitle("Application");
                stage.show();

                usernameField.getScene().getWindow().hide(); // chowamy stare okno
            } catch (IOException e){
                e.printStackTrace();
            }

        } else {
            AlertService.showAlert(
                    Alert.AlertType.ERROR,
                    "Registration failed",
                    "Your registration form is invalid, please correct shown errors.",
                    usernameField.getScene().getWindow());
        }
        //        System.out.println(UserDao.existByUsername(usernameField.getText()));

    }


    private boolean isNotEmpty(TextField field, boolean showAlert, Label errorLabel) {
        if (field.getText().isEmpty()) {
            errorLabel.setVisible(true);
            errorLabel.setText("Field is empty");
        }

        if (showAlert) {
            AlertService.showAlert(
                    Alert.AlertType.ERROR,
                    "Registration Failled",
                    "Field is empty",
                    field.getScene().getWindow());

        }
        return !field.getText().isEmpty();

    }


    public void onMouseButton(MouseEvent mouseEvent) {
//        System.out.println("mouse over button");
//        System.out.println("x" + mouseEvent.getSceneX());
//        System.out.println("y" + mouseEvent.getSceneX());
    }


}




