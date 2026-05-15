package fourth;
/*
You are given an integer array nums sorted in non-decreasing order. Your task is to remove duplicates from nums in-place so that each element appears only once.

After removing the duplicates, return the number of unique elements, denoted as k, such that the first k elements of nums contain the unique elements.

Note:

The order of the unique elements should remain the same as in the original array.
It is not necessary to consider elements beyond the first k positions of the array.
To be accepted, the first k elements of nums must contain all the unique elements.
Return k as the final result.

Example 1:

Input: nums = [1,1,2,3,4]

Output: [1,2,3,4]
*/

public class ProblemNC50 {
    public static void main(String[] args) {
        SolutionNC50 solution = new SolutionNC50();
        System.out.println(solution.removeDuplicates(new int[]{2, 4, 4, 5, 5, 8}));
    }
}

class SolutionNC50 {

    public int removeDuplicates(int[] nums) {
        int l = 0, n = nums.length, r = 0;

        while (r < n) {
            nums[l] = nums[r];
            while (r < n && nums[l] == nums[r]) {
                r++;
            }
            l++;
        }

        return l;
    }

}

