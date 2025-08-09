package third;

/*
Given a string s, return the longest palindromic substring in s.

Manacher's algorithm:
Transform the string to avoid handling even/odd length cases separately:

Insert a special character (like #) between each character and at the ends.

For example, "abba" becomes "^#a#b#b#a#$" (the ^ and $ are sentinels to avoid bounds checking).

Create an array P where P[i] will store the radius (half-length) of the palindrome centered at index i in the transformed string.

Maintain:

C → the center of the current palindrome.

R → the right boundary of the current palindrome (i.e., C + P[C]).

For each character at position i:

Mirror index: i_mirror = 2*C - i (center - (i - center))

If i < R, set P[i] = min(R - i, P[i_mirror]) (use previously computed info).

Try to expand around i as long as characters match.

If the palindrome centered at i expands past R, update C and R.

Finally, find the index with the maximum P[i], and extract the longest palindrome from the original string.
 */

public class ProblemDSA24 {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        SolutionDSA24 solution = new SolutionDSA24();
        System.out.println(solution.longestPalindrome(s));
    }
}

class SolutionDSA24 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);
        int maxLen = 1;
        s = "#" + s.replaceAll("", "#") + "#";
        int n = s.length();
        int[] dp = new int[n];
        int center = 0, right = 0;

        for (int i = 0; i < n; i++) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < n && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > right) {
                right = i + dp[i];
                center = i;
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxStr = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
            }
        }

        return maxStr;
    }
}