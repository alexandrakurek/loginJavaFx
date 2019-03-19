package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Main extends Application {

    @Override
    public void init() throws Exception{
        super.init();
        // inicjalizowanie danych do aplikacji
        System.out.println("before start");
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Label label = new Label("napis");

        // glowny kontener z kolumnami i wierszami
        GridPane root = new GridPane();

        // wyrownywanie elementow w kontenerze
        root.setAlignment(Pos.BASELINE_CENTER);

        //
        root.setPadding(new Insets(10)); // marginesy pomiedzy tekstme a ramka tablicy, marginesy - zwykle to sa na zewnatrz ramki

        // odstepy powmiedzy kolumnami
        root.setHgap(10);

        //odstepny pomiedzy wierszami
        root.setVgap(100);

        // dodawanie do kontenera, pierwszy parametr - element do dodania, 2- kolumna, 3-wiersz)
        root.add(label,0,0);

//        //colspan - na ile kolumn ma sie rozciagac, rowspan - w dol
        root.add(new Label("11212121121"),1,1,3,4);
        root.add(new Label("11"),0,2);
        root.add(new Label("22"),1,2);
        root.add(new Label("33"),2,2);


        for(int x=1;x<6;x++){ // kolumny
            for(int y=0; y<5; y++){ // wiersze
                root.add(new Label("nanana" + x + y),x,y);
            }
        }

        root.add(new Label("Header1"),0,0,3,1);
        root.add(new Label("Header2"),3,0,3,1);
        root.add(new Label("COLUMN \n"),0,1,1,5);

//        ColumnConstraints columnConstraints3= new ColumnConstraints(200,300,300);
//        columnConstraints3.setHalignment(HPos.RIGHT);
//        root.getColumnConstraints()
//                .addAll(columnConstraints3);









        // ograniczenia kolumn minimalna szerokosc, domyslna szer, max szer
        ColumnConstraints columnConstraints = new ColumnConstraints(100,200,200);
        columnConstraints.setHalignment(HPos.LEFT);
        ColumnConstraints columnConstraints1 = new ColumnConstraints(100,200,200);
        ColumnConstraints columnConstraints2 = new ColumnConstraints(100,200,Double.MAX_VALUE);

        root.getColumnConstraints()
                .addAll(columnConstraints,columnConstraints1,columnConstraints2);



        primaryStage.setTitle("Application");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception{
        super.stop();

        //finalizowanie aplikacji
        System.out.println("after closing window");
    }
}
