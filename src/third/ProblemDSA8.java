package third;
/*
Given a string s having lowercase characters, find the length of the longest substring without repeating characters.

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: The longest substrings without repeating characters are "eksforg” and "ksforge", with lengths of 7.

Input: s = "aaa"
Output: 1
Explanation: The longest substring without repeating characters is "a"

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring without repeating characters is "abcdef".
*/

public class ProblemDSA8 {
    public static void main(String[] args) {
        SolutionDSA8 solution = new SolutionDSA8();
        System.out.println(solution.longestUniqueSubstr("geeksforgeeks"));
    }
}

class SolutionDSA8 {

    public int longestUniqueSubstr(String s) {
        int left = 0, right = 0;

        boolean[] visited = new boolean[26];
        int longest = 0;

        while (right < s.length()) {
            while (visited[s.charAt(right) - 'a']) {
                visited[s.charAt(left) - 'a'] = false;
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            visited[s.charAt(right) - 'a'] = true;
            right++;
        }

        return longest;
    }

}
