package third;
/*
Given two strings s1 and s2 and below operations that can be performed on s1. The task is to find the minimum number of edits (operations) to
convert 's1' into 's2'.

Insert: Insert any character before or after any index of s1
Remove: Remove a character of s1
Replace: Replace a character at any index of s1 with some other character.
Note: All of the above operations are of equal cost.

Examples:

Input: s1 = "geek", s2 = "gesek"
Output: 1
Explanation: We can convert s1 into s2 by inserting an 's' between two consecutive 'e' in s1.

Input: s1 = "gfg", s2 = "gfg"
Output: 0
Explanation: Both strings are same.

Input: s1 = "abcd", s2 = "bcfe"
Output: 3
Explanation: We can convert s1 into s2 by removing 'a', replacing 'd' with 'f' and inserting 'e' at the end.
*/

public class ProblemDSA87 {
    public static void main(String[] args) {
        SolutionDSA87 solution = new SolutionDSA87();

        System.out.println(solution.editDistance("abcd", "bcfe"));
    }
}

class SolutionDSA87 {

    public int editDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] curr = new int[m + 1];
        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(Math.min(curr[j - 1], prev[j]), prev[j - 1]);
                }
            }
            prev = curr.clone();
        }

        return curr[m];
    }
}

