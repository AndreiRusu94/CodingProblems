package first;
/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */

import java.util.Arrays;

public class Problem31 {
    public static void main(String[] args) {
        Solution31 solution = new Solution31();

        int[] input = {1, 2, 3, 8, 6, 4};
        solution.nextPermutation(input);
        Arrays.stream(input).forEach(System.out::println);
    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;

            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i+1);
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public void reverse(int[] nums, int start) {
        int j = nums.length - 1;

        while (start < j) {
            swap(nums, start, j);
            start++;
            j--;
        }
    }
}