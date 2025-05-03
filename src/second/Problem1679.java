package second;

/*
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 */

import java.util.HashMap;
import java.util.Map;

public class Problem1679 {

    public static void main(String[] args) {
        Solution1679 solution = new Solution1679();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxOperations(height, 9));
    }
}

class Solution1679 {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> numToCount = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = k - nums[i];

            if (numToCount.containsKey(diff)) {
                count++;
                numToCount.computeIfPresent(diff, (key, v) -> (v == 1) ? null : v - 1);
            } else {
                numToCount.put(nums[i], numToCount.getOrDefault(nums[i], 0) + 1);
            }
        }

        return count;
    }
}
