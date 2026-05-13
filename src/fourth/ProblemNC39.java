package fourth;
/*
You are given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than
or equal to target. If there is no such subarray, return 0 instead.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: target = 10, nums = [2,1,5,1,5,3]

Output: 3
Explanation: The subarray [5,1,5] has the minimal length under the problem constraint.
*/

public class ProblemNC39 {
    public static void main(String[] args) {
        SolutionNC39 solution = new SolutionNC39();
        System.out.println(solution.minSubArrayLen(10, new int[]{2, 1, 5, 1, 5, 3}));
    }
}

class SolutionNC39 {

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int total = 0, l = 0;
        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                minLength = Math.min(minLength, r - l + 1);
                total -= nums[l++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}

