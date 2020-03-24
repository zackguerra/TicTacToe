package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import sample.Model.Judge;
import sample.Model.Player;
import sample.View.PopupWindow;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Button btn0;
    @FXML
    public Button btn1;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    @FXML
    public Button btn5;
    @FXML
    public Button btn6;
    @FXML
    public Button btn7;
    @FXML
    public Button btn8;
    @FXML
    private Label player;
    @FXML
    private GridPane gridlayout;


    private boolean isO;
    private Player player1;
    private Player player2;
    private Button[][] grid;
    private Judge tttJudge;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /// initializing instance variables (properties)
        /// 1. Create two players with names (Player)
        isO = true;
        player1 = new Player("Zack");
        player2 = new Player("Pri");
        grid = new Button[][]{
                {btn0, btn1, btn2},
                {btn3, btn4, btn5},
                {btn6, btn7, btn8}
        };
        tttJudge = new Judge(grid);
        /// 2. Display their name on Label(player)
        changeLabel();
    }

    /// 3. Take turns
    private void changeLabel() {
        if (isO) {
            player.setText(player1.getName());
        } else {
            player.setText(player2.getName());
        }
    }

    @FXML
    public void buttonClicked(ActionEvent actionEvent) {
        Button btnClicked = (Button) actionEvent.getSource();
        // 0. check if O or X is already there.
        if (btnClicked.getText().equals("")) {
            // 1. switch players (symbols O , X)
            if (isO) {
                btnClicked.setText("O");
            } else {
                btnClicked.setText("X");
            }
            judge();
            isO = !isO;
            changeLabel();
        }
    }

    private void judge() {
        // -1, 0, 1, 2, 3, 4, 5, 6, 7, 8
        int result = tttJudge.getResult();
        switch (result) {
            case 0:
                //draw
                displayResult(true);
                reset();
                break;
            case 1:
                // first row
                drawline(0, 50, 300,50);
                break;
            case 2:
                // second row
                drawline(0, 150,300,150);
                break;
            case 3:
                // third row
                drawline(0, 250, 300,250);
                break;
            case 4:
                // first col
                drawline(50, 0,50, 300);
                break;
            case 5:
                // second col
                drawline(150, 0,150, 300);
                break;
            case 6:
                // third col
                drawline(250, 0,250, 300);
                break;
            case 7:
                // diag 1
                drawline(0, 0,300, 300);
                break;
            case 8:
                drawline(300,0,0, 300);
                // diag 2
                break;
            default:
                // keep going!
                break;
        }
    }

    public void displayResult(boolean draw) {
        if (!draw) {
            if (isO) {
                PopupWindow.display("Game Over", player1.getName() + " won!");
            } else {
                PopupWindow.display("Game Over", player2.getName() + " won!");
            }
        } else {
            PopupWindow.display("Game Over", "Draw!");
        }
    }

    public void drawline(int startX, int startY, int endX, int endY) {
        // 1. create a line
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(Paint.valueOf("red"));
        // 2. create an empty pane
        Pane canvas = new Pane();
        canvas.setPrefSize(300, 300);
        canvas.getChildren().add(line); // adding the line to the pane

        // 3. get the parent StackPane
        StackPane stackPane = (StackPane) gridlayout.getParent();
        stackPane.getChildren().add(canvas); // add the pane to StackPane

        displayResult(false);

        // reset
        stackPane.getChildren().remove(canvas); // remove line(canvas) from the StackPane
        reset();
    }

    public void reset() {
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid.length; c++) {
                grid[r][c].setText("");
            }
        }
        // reset the tic-tac-toe judge
        tttJudge = new Judge(grid);
    }
}
