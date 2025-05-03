package second;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */

public class Problem1004 {

    public static void main(String[] args) {
        Solution1004 solution = new Solution1004();
        System.out.println(solution.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}

class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int max = 0, zeros = 0, left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            if (zeros <= k) {
                max = Math.max(max, i - left + 1);
            }
        }

        return max;
    }
}
