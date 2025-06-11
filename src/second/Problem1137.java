package second;

/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
*/

public class Problem1137 {

    public static void main(String[] args) {
        Solution1137 solution = new Solution1137();
        System.out.println(solution.tribonacci(13));

    }
}

class Solution1137 {
    public int tribonacci(int n) {
        int dp[] = new int[n + 3];
        int count = 3;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        while (count <= n) {
            dp[count] = dp[count - 1] + dp[count - 2] + dp[count - 3];
            count++;
        }

        return dp[n];
    }
}