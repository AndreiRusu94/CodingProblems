package second;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 */

public class Problem392 {

    public static void main(String[] args) {
        Solution392 solution = new Solution392();
        System.out.println("Is subsequence: " + solution.isSubsequence("abc", "ahbgdc"));
    }
}

class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        if (sLength == 0) {
            return true;
        }

        int i = 0, j = 0;

        while (j < t.length() && i < sLength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == sLength;
    }
}
