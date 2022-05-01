package first;
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

  Example 1:

    Input: [1,3,5,6], 5
    Output: 2
 */


public class Problem35 {
    public static void main(String[] args) {
        Solution35 solution = new Solution35();

        int[] input = {1, 2, 3, 5, 5, 6};
        System.out.println(solution.searchInsert(input, 5));
    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

}