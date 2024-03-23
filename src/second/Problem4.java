package second;

/*
    4. Median of Two Sorted Arrays

    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

    The overall run time complexity should be O(log (m+n)).
*/


import java.util.ArrayList;
import java.util.List;

public class Problem4 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{2};

        Solution4 solution4 = new Solution4();
        System.out.println(solution4.findMedianSortedArrays(nums1, nums2));
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        int size1 = nums1.length;
        int size2 = nums2.length;
        int size = size1 + size2;
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                result.add(nums1[i++]);
            } else {
                result.add(nums2[j++]);
            }

            if (size % 2 == 0 && i + j - 1 == size / 2) {
                return (double)(result.get(size / 2 - 1) + result.get(size / 2)) / 2;
            } else if (size % 2 == 1 && i + j - 1 == size / 2) {
                return result.get(size / 2);
            }
        }

        while (i < nums1.length) {
            result.add(nums1[i++]);
        }

        while (j < nums2.length) {
            result.add(nums2[j++]);
        }

        if (result.isEmpty()) {
            return 0;
        }

        int resultSize = result.size();

        System.out.println(result);
        return resultSize % 2 == 0 ?
                (double)((result.get(resultSize / 2 - 1) + result.get(resultSize / 2))) / 2 :
                result.get(resultSize / 2);
    }
}