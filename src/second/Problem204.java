package second;
/*
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0
*/

import java.util.Arrays;

public class Problem204 {
    public static void main(String[] args) {
        Solution204 solution = new Solution204();

        System.out.println(solution.countPrimes(22));
    }
}

class Solution204 {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }

        return count;
    }
}
