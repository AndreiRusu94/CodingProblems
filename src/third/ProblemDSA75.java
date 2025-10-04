package third;
/*
You are given a list of strings, words[], and an n × m matrix of characters, letters[][]. The objective is to locate all the words from words[]
that can be constructed by consecutively linking adjacent characters in the matrix. You are allowed to move in any of the 8 possible directions
(horizontally, vertically, or diagonally), but each cell in the matrix can be used only once per word.

Example:

Input: words[] = [ "geeks", "for", "quiz", "go" ]
letters[][] = [[ 'g', 'i', 'z' ],
                      [ 'u', 'e', 'k' ],
                      [ 'q', 's', 'e' ]]
Output: geeks quiz
Explanation: To form the word "geeks", begin at cell (0,0) containing 'g'. Next, proceed diagonally down-right to cell (1,1) with 'e', then
continue in the same diagonal direction to cell (2,2) for another 'e'. After that, move upward to cell (1,2) to pick up 'k', and finally,
go diagonally down-left to cell (2,1) to complete the word with 's'.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemDSA75 {
    public static void main(String[] args) {
        SolutionDSA75 solution = new SolutionDSA75();

        List<String> words = Arrays.asList("geeks", "for", "quiz", "go");
        char[][] letters = {
                {'g', 'i', 'z'},
                {'u', 'e', 'k'},
                {'q', 's', 'e'}
        };
        List<String> ans = solution.findWords(words, letters);
        System.out.println(ans);
    }
}

class SolutionDSA75 {

    public List<String> findWords(List<String> words, char[][] letters) {
        int n = letters.length;
        int m = letters[0].length;
        int r = words.size();
        Set<String> output = new HashSet<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m ; k++) {
                    if (dfs(letters, words.get(i), j, k, 0)) {
                        output.add(words.get(i));
                    }
                }
            }
        }

        return new ArrayList<>(output);
    }

    private boolean dfs(char[][] letters, String word, int i, int j, int index) {
        if (i < 0 || i >= letters.length || j < 0 || j >= letters[0].length) {
            return false;
        }

        if (letters[i][j] != word.charAt(index)) {
            return false;
        }

        if (word.length() - 1 == index) {
            return true;
        }

        char temp = letters[i][j];
        letters[i][j] = '#';

        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }

                if (dfs(letters, word, i + row, j + col, index + 1)) {
                    letters[i][j] = temp;
                    return true;
                }
            }
        }

        letters[i][j] = temp;
        return false;
    }

}

