package sample.Model;

import javafx.scene.control.Button;

public class Judge {
    private int count;
    private Button[][] board;

    public Judge(Button[][] board) {
        this.count = 0;
        this.board = board;
    }

    /**
     * -1: not yet
     * 0: draw
     * 1: row 1
     * 2: row 2
     * 3: row 3
     * 4: col 1
     * 5: col 2
     * 6: col 3
     * 7: diag 1
     * 8: diag 1
     * @return
     */
    public int getResult() {
        count++;
        // rows
        if (!board[0][0].getText().isEmpty()
                && board[0][0].getText().equals(board[0][1].getText())
                && board[0][1].getText().equals(board[0][2].getText())) {
            return 1;
        }
        if (!board[1][0].getText().isEmpty()
                && board[1][0].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[1][2].getText())) {
            return 2;
        }
        if (!board[2][0].getText().isEmpty()
                && board[2][0].getText().equals(board[2][1].getText())
                && board[2][1].getText().equals(board[2][2].getText())) {
            return 3;
        }
        // cols
        if (!board[0][0].getText().isEmpty()
                && board[0][0].getText().equals(board[1][0].getText())
                && board[1][0].getText().equals(board[2][0].getText())) {
            return 4;
        }
        if (!board[0][1].getText().isEmpty()
                && board[0][1].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][1].getText())) {
            return 5;
        }
        if (!board[0][2].getText().isEmpty()
                && board[0][2].getText().equals(board[1][2].getText())
                && board[1][2].getText().equals(board[2][2].getText())) {
            return 6;
        }
        // diagonals
        if (!board[0][0].getText().isEmpty()
                && board[0][0].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][2].getText())) {
            return 7;
        }
        if (!board[0][2].getText().isEmpty()
                && board[0][2].getText().equals(board[1][1].getText())
                && board[1][1].getText().equals(board[2][0].getText())) {
            return 8;
        }
        // draw
        if (count == 9) {
            return 0;
        }
        // no match & no draw
        return -1;
    }



}
