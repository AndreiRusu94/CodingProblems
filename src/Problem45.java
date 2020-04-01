/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

  Example:

    Input: [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2.
        Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */


public class Problem45 {
    public static void main(String[] args) {
        Solution45 solution = new Solution45();

        int[] candidates = {1,1,3,1,4};

        System.out.println(solution.jump(candidates));
    }
}

class Solution45 {
    public int jump(int[] nums) {
        int currentEnd = 0, currentFarthest = 0, jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentFarthest = Math.max(currentFarthest, nums[i] + i);

            if (i == currentEnd) {
                jumps++;
                currentEnd = currentFarthest;
            }
        }

        return jumps;
    }
}