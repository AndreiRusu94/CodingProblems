/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.

    Example:

    Input:
    nums1 = [1,2,3,0,0,0], m = 3
    nums2 = [2,5,6],       n = 3

    Output: [1,2,2,3,5,6]
*/

import java.util.Arrays;

public class Problem88 {
    public static void main(String[] args) {
        Solution88 solution = new Solution88();

        int[] nums1 = {2, 4, 6, 0, 0, 0};
        int[] nums2 = {3, 4, 5};
        int n = 3, m = 3;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= 0; i--) {
            if (m > 0 && n > 0) {
                if (nums1[m - 1] >= nums2[n - 1]) {
                    nums1[i] = nums1[m - 1];
                    m--;
                } else {
                    nums1[i] = nums2[n - 1];
                    n--;
                }
            } else {
                while (m > 0) {
                    nums1[i] = nums1[m - 1];
                    m--;
                    i--;
                }

                while (n > 0) {
                    nums1[i] = nums2[n - 1];
                    n--;
                    i--;
                }
            }
        }
    }
}
