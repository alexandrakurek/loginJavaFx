package registration_form;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Registration extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        primaryStage.setScene(new Scene(root,700,600));
        primaryStage.setTitle("Registration");
        primaryStage.show();

    }
}
