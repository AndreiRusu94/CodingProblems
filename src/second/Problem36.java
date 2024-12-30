package second;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> square = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int squareNumber = (i / 3) * 3 + (j / 3) + 1;
                if (square.get(squareNumber) != null) {
                    if (!square.get(squareNumber).add(board[i][j])) {
                        return false;
                    }
                } else {
                    var set = new HashSet<Character>();
                    set.add(board[i][j]);
                    square.put(squareNumber, set);
                }

                if (rows.get(i) != null) {
                    if (!rows.get(i).add(board[i][j])) {
                        return false;
                    }
                } else {
                    var set = new HashSet<Character>();
                    set.add(board[i][j]);
                    rows.put(i, set);
                }

                if (columns.get(j) != null) {
                    if (!columns.get(j).add(board[i][j])) {
                        return false;
                    }
                } else {
                    var set = new HashSet<Character>();
                    set.add(board[i][j]);
                    columns.put(j, set);
                }
            }
        }
        return true;
    }
}