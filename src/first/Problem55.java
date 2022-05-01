package first;
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

  Example 1:

    Input: [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

  Example 2:

    Input: [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.
 */

public class Problem55 {
    public static void main(String[] args) {
        Solution55 solution = new Solution55();

        int[] nums = {3, 2, 1, 0, 4};

        System.out.println(solution.canJump(nums));
    }
}

enum Index {
    GOOD, BAD, UNKNOWN
}

class Solution55 {
    Index[] memoization;

    public boolean canJump(int[] nums) {
        memoization = new Index[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memoization[i] = Index.UNKNOWN;
        }

        memoization[nums.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(nums.length - 1, i + nums[i]);

            for (int j = i + 1; j <= furthestJump; j++) {
                if (memoization[j] == Index.GOOD) {
                    memoization[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memoization[0] == Index.GOOD;
    }
}