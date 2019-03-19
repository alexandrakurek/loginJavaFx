package gridPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("gridPane.fxml")); // ladujemy plik z ktorego wyciagamy element
        primaryStage.setScene(new Scene(root,800,600)); // wystawiamy element na scene
        primaryStage.setTitle("GridPane example"); // sstawiamy tytul
        primaryStage.show(); // pokazujemy
    }

    public static void main(String[] args) {
        launch(args);
    }
}
