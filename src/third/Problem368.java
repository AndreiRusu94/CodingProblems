package third;
/*
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem368 {
    public static void main(String[] args) {
        Solution368 solution = new Solution368();

        System.out.println(solution.largestDivisibleSubset(new int[]{5, 9, 18, 54, 108, 540, 90, 180, 360, 720}));
    }
}

class Solution368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        int[] prevIndex = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndex, -1);

        int maxi = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j;
                }
            }

            if (dp[maxi] < dp[i]) {
                maxi = i;
            }
        }

        List<Integer> output = new ArrayList<>();
        for (int i = maxi; i >= 0; i = prevIndex[i]) {
            output.add(nums[i]);
        }

        return output;
    }

}

