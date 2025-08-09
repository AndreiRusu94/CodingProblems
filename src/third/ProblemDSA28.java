package third;

/*
Given a string s and y a dictionary of n words dictionary, check if s can be segmented into a sequence of valid words from the dictionary, separated by spaces.

Examples:

Input:  s = "ilike", dictionary[] = ["i", "like", "gfg"]
Output: true
Explanation: The string can be segmented as "i like".

Input:  s = "ilikegfg", dictionary[] = ["i", "like", "man", "india", "gfg"]
Output: true
Explanation: The string can be segmented as "i like gfg".

Input: "ilikemangoes", dictionary = ["i", "like", "gfg"]
Output: false
Explanation: The string cannot be segmented.
*/

public class ProblemDSA28 {

    public static void main(String[] args) {
        SolutionDSA28 solution = new SolutionDSA28();
        System.out.println(solution.wordBreak(new String[]{"i", "like", "gfg"}, "ilike"));
    }
}

class SolutionDSA28 {
    public boolean wordBreak(String[] dictionary, String s) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : dictionary) {
                int start = i - word.length();
                if (start >= 0 && dp[start] && s.substring(start, start + word.length()).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}