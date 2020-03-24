package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/sample.fxml"));
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(root);

        primaryStage.setTitle("Tic Tac Toe");
        Scene boardScene = new Scene(stackPane, 300,330);

        boardScene.getStylesheets().add("sample/View/css/styles.css"); // adding css to the scene
        primaryStage.setScene(boardScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
