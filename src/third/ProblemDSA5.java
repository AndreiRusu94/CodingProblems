package third;
/*
Given an array arr[] and a target value, the task is to find the count of triplets present in the given array having sum equal to the given target.

Examples:

Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: 2
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = 0 + (-3) + (1) = -2
arr[1] + arr[2] + arr[3] = (-1) + 2 + (-3) = -2

Input: arr[] = [1, -2, 1, 0, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1.
*/

import java.util.HashMap;
import java.util.Map;

public class ProblemDSA5 {
    public static void main(String[] args) {
        SolutionDSA5 solution = new SolutionDSA5();
        int[] arr = new int[]{1, -2, 1, 0, 5};
        System.out.println(solution.countTriples(arr, 1));
    }
}

class SolutionDSA5 {

    public int countTriples(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            count += countPairs(nums, i + 1, remaining);
        }

        return count;
    }

    private int countPairs(int[] nums, int idx, int target) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int i = idx; i < nums.length; i++) {
            if (freq.containsKey(target - nums[i])) {
                count += freq.get(target - nums[i]);
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        return count;
    }

}
