package third;
/*
Given two strings s1 and s2, the task is to check if the given strings can be made equal by inserting at most one string to one of the strings at
any index.

Examples:

Input : s1 = "geeksforgeeks", s2 = "geeksgeeks"
Output : Yes
Explanation: Add string "for" after 4th index to s2.

Input: s1 = "geekforgeeks", s2 = "geeksgeeks"
Output: No
Explanation: string s1 has extra "for" and s2 has an extra "s".
*/

public class ProblemDSA49 {
    public static void main(String[] args) {
        SolutionDSA49 solution = new SolutionDSA49();

        System.out.println(solution.isEqual("geekforgeeks", "geeksgeeks"));
    }
}

class SolutionDSA49 {
    public boolean isEqual(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n == m) {
            return s1.equals(s2);
        }

        if (n < m) {
            return isEqual(s2, s1);
        }

        int i = 0;
        while (i < m && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }

        int j = 0;
        while (j < m && s1.charAt(n - 1 - j) == s2.charAt(m - 1 - j)) {
            j++;
        }

        return i + j >= m;
    }


}