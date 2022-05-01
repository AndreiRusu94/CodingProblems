package first;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
vertically neighboring. The same letter cell may not be used more than once.

  Example:

    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.


Constraints:

board and word consists only of lowercase and uppercase English letters.
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */

public class Problem79 {
    public static void main(String[] args) {
        Solution79 solution = new Solution79();

        char[][] nums = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(nums, "DECC"));
    }
}

class Solution79 {
    public boolean exist(char[][] board, String word) {
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordExists(board, wordArray, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean wordExists(char[][] board, char[] wordArray, int row, int column, int start) {
        if (start == wordArray.length) {
            return true;
        }

        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length) {
            return false;
        }


        if (board[row][column] == '#' || board[row][column] != wordArray[start]) {
            return false;
        }

        char c = board[row][column];
        board[row][column] = '#';

        boolean exists = wordExists(board, wordArray, row - 1, column, start + 1)
                || wordExists(board, wordArray, row, column - 1, start + 1)
                || wordExists(board, wordArray, row, column + 1, start + 1)
                || wordExists(board, wordArray, row + 1, column, start + 1);

        board[row][column] = c;

        return exists;
    }
}
