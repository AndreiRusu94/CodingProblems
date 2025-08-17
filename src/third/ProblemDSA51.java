package third;
/*
Given a string s and an integer k, find the lexicographically largest string that can be obtained by removing exactly k characters from s, while preserving the relative order of the remaining characters.

Examples:

Input: s = "zebra", k = 3
Output: "zr"
Explanation: Removing "e", "b", and "a" results in "zr", which is lexicographically the greatest.

Input: s = "ritz", k = 2
Output: "tz"
Explanation: By removing two characters in all possible ways, we get: "ri", "rt", "rz", "it", "iz", and "tz". Among these, "tz" is lexicographically the largest.

Input: s = "jackie", k = 2
Output: "jkie"
Explanation: Removing "a" and "c" gives "jkie", which is the largest string possible in dictionary order.
*/

public class ProblemDSA51 {
    public static void main(String[] args) {
        SolutionDSA51 solution = new SolutionDSA51();

        System.out.println(solution.maxSubseq("zebraz", 3));
    }
}

class SolutionDSA51 {
    public String maxSubseq(String s, int k) {
        StringBuilder output = new StringBuilder();

        int charsToRemove = k;

        for (int i = 0; i < s.length(); i++) {
            while (output.length() > 0 && charsToRemove > 0 && s.charAt(i) > output.charAt(output.length() - 1)) {
                output.deleteCharAt(output.length() - 1);
                charsToRemove--;
            }
            output.append(s.charAt(i));
        }

        return output.substring(0, s.length() - k);
    }


}