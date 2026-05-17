package fourth;
/*
You are given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

Example 1:

Input: nums = [-2,4,-5,4,-5,9,4]

Output: 15
Explanation: Subarray [-2,4,9,4] has maximum sum 15.

Example 2:

Input: nums = [2,3,-4]

Output: 5

Kadane (when the max subarray is in the middle of the array) and the sum between what comes before and after the index.
*/

public class ProblemNC60 {
    public static void main(String[] args) {
        SolutionNC60 solution = new SolutionNC60();
        System.out.println(solution.maxSubarraySumCircular(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class SolutionNC60 {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];

        int suffixSum = nums[n - 1];
        rightMax[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(suffixSum, rightMax[i + 1]);
        }

        int maxSum = nums[0];
        int currMax = 0;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            currMax = Math.max(currMax, 0) + nums[i];
            maxSum = Math.max(currMax, maxSum);
            prefixSum += nums[i];
            if (i + 1 < n) {
                maxSum = Math.max(prefixSum + rightMax[i + 1], maxSum);
            }
        }

        return maxSum;
    }

}

