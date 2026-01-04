package third;
/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem349 {
    public static void main(String[] args) {
        Solution349 solution = new Solution349();

        System.out.println(Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}


class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<>();
        int n = nums1.length, m = nums2.length;

        for (int i = 0; i < n; i++) {
            nums.add(nums1[i]);
        }

        Set<Integer> output = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if (nums.contains(nums2[i])) {
                output.add(nums2[i]);
            }
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}


