/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

  Example:

    Input: 4
    Output: [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */

import java.util.ArrayList;
import java.util.List;

public class Problem51 {
    public static void main(String[] args) {
        Solution51 solution = new Solution51();

        System.out.println(solution.solveNQueens(5));
    }
}

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solveQueens(board, output, 0);

        return output;
    }

    private void solveQueens(char[][] board, List<List<String>> output, int colIndex) {
        if (colIndex == board.length) {
            output.add(constructOutput(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValidQueenPosition(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                solveQueens(board, output, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }

    private List<String> constructOutput(char[][] board) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            output.add(new String(board[i]));
        }

        return output;
    }

    private boolean isValidQueenPosition(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x == i || x + y == i + j || x + j == y + i)) {
                    return false;
                }
            }
        }

        return true;
    }
}