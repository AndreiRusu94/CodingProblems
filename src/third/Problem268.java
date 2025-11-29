package third;
/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:

Input: nums = [3,0,1]

Output: 2

Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:
n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8

Explanation:
n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

*/

import java.util.Arrays;

public class Problem268 {
    public static void main(String[] args) {
        Solution268 solution = new Solution268();

        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(solution.missingNumber(nums));
    }
}

class Solution268 {

    public int missingNumber(int[] nums) {
        int[] counts = new int[nums.length + 1];

        for (int num : nums) {
            counts[num]++;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (counts[i] == 0) {
                return i;
            }
        }

        return -1;
    }

}

