package second;

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
 */

public class Problem724 {

    public static void main(String[] args) {
        Solution724 solution = new Solution724();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class Solution724 {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            total += nums[i];
        }

        int leftSum = 0;
        if (total == leftSum) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            total -= nums[i];
            leftSum += nums[i - 1];
            if (total == leftSum) {
                return i;
            }
        }

        return -1;
    }
}
