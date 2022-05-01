package first;
/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */


public class Problem36 {
    public static void main(String[] args) {
        Solution36 solution = new Solution36();

        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(input));
    }
}

class Solution36 {
    private static final int LENGTH_OF_CATHETHUS = 9;

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < LENGTH_OF_CATHETHUS; i++) {
            for (int j = 0; j < LENGTH_OF_CATHETHUS; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    if (invalidSquare(i, j, board)) {
                        return false;
                    }
                }

                if (board[i][j] != '.') {
                    for (int k = i + 1; k < LENGTH_OF_CATHETHUS; k++) {
                        if (board[i][j] == board[k][j]) {
                            return false;
                        }
                    }

                    for (int k = j + 1; k < LENGTH_OF_CATHETHUS; k++) {
                        if (board[i][j] == board[i][k]) {
                            return false;
                        }
                    }
                }
            }
        }


        return true;
    }

    public boolean invalidSquare(int rowStart, int columnStart, char[][] board) {
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = columnStart; j < columnStart + 3; j++) {
                if (board[i][j] != '.') {
                    for (int x = rowStart; x < rowStart + 3; x++) {
                        for (int y = columnStart; y < columnStart + 3; y++) {
                            if (x != i && y != j) {
                                if (board[i][j] == board[x][y]) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}