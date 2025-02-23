package second;
/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Unoptimized solution
class Solution212 {
    public static void main(String[] args) {
        Solution212 sol = new Solution212();
        Trie obj = sol.new Trie();
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        List<String> output = obj.findWords(board, new String[]{"abcb"});
        System.out.println(output);
    }

    class Trie {
        int maxLength = 0;
        Set<Character> chars = new HashSet<>();
        Set<String> wds = new HashSet<>();
        boolean[][] visited;

        public List<String> findWords(char[][] board, String[] words) {
            visited = new boolean[board.length][board[0].length];
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    chars.add(c);
                }

                if (word.length() > maxLength) {
                    maxLength = word.length();
                }

                wds.add(word);
            }

            List<String> output = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    backtrack(output, new StringBuilder(), 0, i, j, board, visited);
                }
            }


            return output;
        }

        private void backtrack(List<String> output, StringBuilder tmp, int k, int i, int j, char[][] board, boolean[][] visited) {
            if (wds.contains(tmp.toString())) {
                output.add(tmp.toString());
                wds.remove(tmp.toString());
            }

            if (k <= maxLength) {
                if (i >= 0 && j >= 0 && i < board.length && j < board[0].length) {
                    if (visited[i][j]) {
                        return;
                    }

                    tmp.append(board[i][j]);
                    visited[i][j] = true;
                    backtrack(output, tmp, k + 1, i - 1, j, board, visited);
                    backtrack(output, tmp, k + 1, i + 1, j, board, visited);
                    backtrack(output, tmp, k + 1, i, j - 1, board, visited);
                    backtrack(output, tmp, k + 1, i, j + 1, board, visited);
                    tmp.deleteCharAt(k);
                    visited[i][j] = false;
                }
            }
        }
    }
}
