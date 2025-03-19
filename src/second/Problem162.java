package second;
/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
*/

public class Problem162 {
    public static void main(String[] args) {
        Solution162 solution = new Solution162();

        System.out.println("Peak element index: " + solution.findPeakElement(new int[]{1, 8, 5, 7}));
    }
}

class Solution162 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int left, int right) {
        if (left == 0) {
            if (nums[1] < nums[0]) {
                return 0;
            }
        }

        if (right == nums.length - 1) {
            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }
        }

        if (left > right) {
            return -1;
        }

        int middle = left + (right - left) / 2;
        if (middle == 0) {
            if (nums[middle] > nums[middle + 1]) {
                return middle;
            }
        } else if (middle == nums.length - 1) {
            if (nums[middle] > nums[middle - 1]) {
                return middle;
            }
        } else if (nums[middle - 1] < nums[middle] && nums[middle] > nums[middle + 1]) {
            return middle;
        }

        int leftIndex = search(nums, left, middle - 1);
        int rightIndex = search(nums, middle + 1, right);

        if (leftIndex >= 0) {
            return leftIndex;
        }

        if (rightIndex >= 0) {
            return rightIndex;
        }

        return -1;
    }
}
