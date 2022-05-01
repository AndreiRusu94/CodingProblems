package first;
/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

  Example 1:

    Given nums = [1,1,1,2,2,3],

    Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

    It doesn't matter what you leave beyond the returned length.

  Example 2:

    Given nums = [0,0,1,1,1,1,2,3,3],

    Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

    It doesn't matter what values are set beyond the returned length.
 */

public class Problem80 {
    public static void main(String[] args) {
        Solution80 solution = new Solution80();

        int[] nums = {0, 0, 0, 1, 1, 1, 1, 4, 4, 5, 6, 7, 7};
        System.out.println(solution.removeDuplicates(nums));
    }
}

class Solution80 {
    public static final int MAX_APPEARANCES = 2;

    public int removeDuplicates(int[] nums) {
        int length = 0;
        int left = 0, right = 0, allowedAppearances = 0;

        while (right < nums.length) {
            if (allowedAppearances < MAX_APPEARANCES) {
                nums[left++] = nums[right++];

                if (right < nums.length && nums[right] == nums[right - 1]) {
                    allowedAppearances++;
                } else {
                    allowedAppearances = 0;
                }

                length++;
            } else {
                while (right < nums.length && nums[right] == nums[left - 1]) {
                    right++;
                }

                allowedAppearances = 0;
            }
        }

        return length;
    }
}
