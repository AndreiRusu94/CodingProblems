package first;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

  Example 1:

    Input: [3,4,5,1,2]
    Output: 1

  Example 2:

    Input: [4,5,6,7,0,1,2]
    Output: 0
*/

public class Problem153 {
    public static void main(String[] args) {
        Solution153 solution = new Solution153();

        int[] nums = {4, 5, 6, 1, 2, 3};
        System.out.println(solution.findMin(nums));
    }
}

class Solution153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle + 1] < nums[middle]) {
                return nums[middle + 1];
            }

            if (nums[middle - 1] > nums[middle]) {
                return nums[middle];
            }

            if (nums[middle] > nums[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
