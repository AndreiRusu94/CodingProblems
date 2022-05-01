package first;
/*
Given an unsorted integer array, find the smallest missing positive integer.

  Example 1:

    Input: [1,2,0]
    Output: 3
    Example 2:

    Input: [3,4,-1,1]
    Output: 2
    Example 3:

    Input: [7,8,9,11,12]
    Output: 1
 */


import java.util.*;

public class Problem41 {
    public static void main(String[] args) {
        Solution41 solution = new Solution41();

        int[] candidates = {2, 3, 6, 7};

        System.out.println(solution.firstMissingPositive(candidates));
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int currentLowestInteger = 1;
        Map<Integer, Boolean> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            values.put(nums[i], true);
        }

        while(values.get(currentLowestInteger) != null) {
            currentLowestInteger++;
        }

        return currentLowestInteger;
    }
}