package fourth;
/*
You are given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3

Example 2:
Input: nums = [1,0,1,1,0,1]

Output: 2
*/

public class ProblemNC1 {
    public static void main(String[] args) {
        SolutionNC1 solution = new SolutionNC1();

        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}

class SolutionNC1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0, maxCount = 0;

        for (int num : nums) {
            currCount = (num == 1) ? currCount + 1 : 0;
            maxCount = Math.max(currCount, maxCount);
        }

        return maxCount;
    }
}
