package second;
/*
Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

  Example 1:

    Input: 00000000000000000000000000001011
    Output: 3
    Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

  Example 2:

    Input: 00000000000000000000000010000000
    Output: 1
    Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

  Example 3:

    Input: 11111111111111111111111111111101
    Output: 31
    Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
*/


public class Problem191_2 {
    public static void main(String[] args) {
        Solution191_2 solution = new Solution191_2();

        System.out.println(solution.hammingWeight(255));
    }
}


class Solution191_2 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }

            n = n >>> 1;
        }
        return count;
    }
}


