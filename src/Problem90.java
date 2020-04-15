/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

    Example:

    Input: [1,2,2]
    Output:
    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {
    public static void main(String[] args) {
        Solution90 solution = new Solution90();

        int[] nums = {1, 2, 2};

        System.out.println(solution.subsetsWithDup(nums));
    }
}

class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();

        backtrack(output, nums, new ArrayList<>(), 0);

        return output;
    }

    private void backtrack(List<List<Integer>> output, int[] nums, List<Integer> tempList, int start) {
        if (start <= nums.length) {
            output.add(new ArrayList<>(tempList));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }

            tempList.add(nums[i]);
            backtrack(output, nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
