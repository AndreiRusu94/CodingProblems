package third;
/*
Given a string s and a non negative integer k, find the length of the longest substring that contains exactly k distinct characters.
If no such substring exists, return -1.

Examples: 

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.

Input: s = "aaaa", k = 2
Output: -1
Explanation: The string contains only one unique character, so there's no substring with 2 distinct characters.

Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.

*/

public class ProblemDSA10 {
    public static void main(String[] args) {
        SolutionDSA10 solution = new SolutionDSA10();
        System.out.println(solution.longestKSubstr(3, "aabacbebebe"));
    }
}

class SolutionDSA10 {

    public int longestKSubstr(int k, String s) {
        int left = 0, right = 0, maxi = - 1, current = 0;
        int[] count = new int[26];

        while (right < s.length()) {
            count[s.charAt(right) - 'a']++;

            if (count[s.charAt(right) - 'a'] == 1) {
                current++;
            }

            while (current > k) {
                count[s.charAt(left) - 'a']--;
                if (count[s.charAt(left) - 'a'] == 0) {
                    current--;
                }
                left++;

            }

            if (current == k) {
                maxi = Math.max(right - left + 1, maxi);
            }

            right++;
        }

        return maxi;
    }

}
