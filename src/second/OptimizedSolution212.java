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

class OptimizedSolution212 {
    public static void main(String[] args) {
        OptimizedSolution212 sol = new OptimizedSolution212();
        Trie obj = sol.new Trie();
        char[][] board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        List<String> output = obj.findWords(board, new String[]{"abcb"});
        System.out.println(output);
    }

    class Trie {
        public List<String> findWords(char[][] board, String[] words) {
            TrieNode root = buildTrie(words);
            Set<String> output = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, root, output, i, j);
                }
            }
            return new ArrayList<>(output);
        }

        private void dfs(char[][] board, TrieNode node, Set<String> output, int i, int j) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' ||
                    node.children[board[i][j] - 'a'] == null) {
                return;
            }

            if (node.children[board[i][j] - 'a'].word != null) {
                output.add(node.children[board[i][j] - 'a'].word);
            }

            node = node.children[board[i][j] - 'a'];
            char c = board[i][j];
            board[i][j] = '#';

            dfs(board, node, output, i - 1, j);
            dfs(board, node, output, i + 1, j);
            dfs(board, node, output, i, j - 1);
            dfs(board, node, output, i, j + 1);

            board[i][j] = c;
        }

        private TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String word : words) {
                TrieNode p = root;
                for (char c : word.toCharArray()) {
                    if (p.children[c - 'a'] == null) {
                        p.children[c - 'a'] = new TrieNode();
                    }

                    p = p.children[c - 'a'];
                }
                p.word = word;
            }
            return root;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
