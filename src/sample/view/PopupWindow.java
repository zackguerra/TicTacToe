package sample.View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopupWindow {

    public static void display(String title, String message) {
        // 1. Stage (window)
        //    -> |Scene|
        //        -> |Root| (Layout: GridPane, StackPane, HBox, VBox,...)
        //            -> (Children) Nodes (Buttons, Labels, ...)

        Stage window = new Stage();
        // while this window is on the screen, you cannot interact
        // with other windows.
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        VBox layout = new VBox(30);
        Label messageLabel = new Label();
        messageLabel.setText(message);
        messageLabel.setStyle("-fx-text-fill: blue; -fx-font-size: 20;");
//        messageLabel.setId("message");


        Button okButton = new Button();
        okButton.setText("OK");
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // close the window!
                window.close();
            }
        });

        layout.getChildren().add(messageLabel);
        layout.getChildren().add(okButton);
        layout.setAlignment(Pos.CENTER);


        Scene scene = new Scene(layout, 200, 80);
        scene.getStylesheets().add("sample/View/css/popup.css");
        window.setScene(scene);
        window.showAndWait();

    }
}
