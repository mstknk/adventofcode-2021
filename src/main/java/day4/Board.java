package day4;

public class Board {
    int board[][];
    String markedBoard[][] = new String[5][5];

    public Board(int[][] board) {
        this.board = board;
    }

    public void mark(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == number) {
                    markedBoard[i][j] = "X";
                }
            }
        }

    }

    public boolean checkBingo() {

        for (int j = 0; j < 5; j++) {
            int xCount = 0;
            int yCount = 0;
            for (int i = 0; i < 5; i++) {
                if (markedBoard[j][i] == "X") {
                    xCount++;
                }
                if (markedBoard[i][j] == "X") {
                    yCount++;
                }
                if (xCount == 5 || yCount == 5) {
                    return true;
                }
            }
        }

        return false;
    }

    public int sumOfUnMarked() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (markedBoard[i][j] != "X") {
                    count += board[i][j];
                }
            }

        }
        return count;
    }
}
