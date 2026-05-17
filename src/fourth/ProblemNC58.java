package fourth;
/*
You are given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [2,-1,1,2], k = 2

Output: 4
Explanation: [2], [2,-1,1], [-1,1,2], [2] are the subarrays whose sum is equals to k.

Example 2:

Input: nums = [4,4,4,4,4,4], k = 4

Output: 6

The key insight is that if prefixSum[j] - prefixSum[i] = k, then the subarray from index i+1 to j has sum k
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProblemNC58 {
    public static void main(String[] args) {
        SolutionNC58 solution = new SolutionNC58();
        System.out.println(solution.subarraySum(new int[]{1, 7, 3, 6, 5, 6}, 7));
    }
}

class SolutionNC58 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        int output = 0, currSum = 0;
        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            output += prefixSums.getOrDefault(diff, 0);
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return output;
    }

}

