package second;
/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
*/

import java.util.HashSet;
import java.util.Set;

public class Problem79 {
    public static void main(String[] args) {
        Solution79 solution = new Solution79();

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "SEE";
        System.out.println("Looking for word: " + word + ". Can be found on the board: " + solution.exist(board, word));
    }
}

class Solution79 {
    private boolean found = false;

    public boolean exist(char[][] board, String word) {
        Set<Character> validCharacters = new HashSet<>();
        for (var c : word.toCharArray()) {
            validCharacters.add(c);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (found) {
                    return true;
                }
                backtrack(board, word, 0, validCharacters, i, j);
            }
        }

        return found;
    }

    private void backtrack(char[][] board, String word, int wordIndex, Set<Character> validCharacters, int row, int col) {
        if (wordIndex >= word.length() || row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] == '*') {
            return;
        }

        if (!validCharacters.contains(word.charAt(wordIndex))) {
            return;
        }

        if (wordIndex == word.length() - 1) {
            if (board[row][col] == word.charAt(wordIndex)) {
                found = true;
            } else {
                return;
            }
        }

        if (board[row][col] == word.charAt(wordIndex)) {
            var c = board[row][col];
            board[row][col] = '*';
            backtrack(board, word, wordIndex + 1, validCharacters, row + 1, col);
            backtrack(board, word, wordIndex + 1, validCharacters, row - 1, col);
            backtrack(board, word, wordIndex + 1, validCharacters, row, col + 1);
            backtrack(board, word, wordIndex + 1, validCharacters, row, col - 1);
            board[row][col] = c;
        }
    }
}
