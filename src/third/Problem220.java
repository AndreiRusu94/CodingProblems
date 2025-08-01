package third;
/*
You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.

Example 1:

Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy the three conditions:
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
Example 2:

Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.

*/

import java.util.TreeSet;

public class Problem220 {
    public static void main(String[] args) {
        Solution220 solution = new Solution220();

        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }
}

class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];

            Long floor = window.floor(val + valueDiff);
            Long ceil = window.ceiling(val - valueDiff);

            if ((floor != null && floor >= val) || (ceil != null && ceil <= val)) {
                return true;
            }

            window.add(val);

            if (i >= indexDiff) {
                window.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}
