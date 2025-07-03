package second;
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

public class Problem350 {
    public static void main(String[] args) {
        Solution350 solution = new Solution350();

        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}


class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] output;
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            output = new int[m];
        } else {
            output = new int[n];
        }

        int i = 0, j = 0, current = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;

                if (i == n) {
                    return Arrays.copyOf(output, current);
                }
            }

            if (nums1[i] > nums2[j]) {
                j++;

                if (j == m) {
                    return Arrays.copyOf(output, current);
                }
            }

            if (nums1[i] == nums2[j]) {
                output[current++] = nums1[i];
                i++;
                j++;
            }
        }

        return Arrays.copyOf(output, current);
    }
}


