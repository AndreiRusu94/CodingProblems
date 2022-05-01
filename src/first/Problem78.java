package first;
/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]
    Output:
    [
      [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]
 */

import java.util.ArrayList;
import java.util.List;

public class Problem78 {
    public static void main(String[] args) {
        Solution78 solution = new Solution78();

        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }
}

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        backtrack(nums, output, new ArrayList<>(), 0);

        return output;
    }

    private void backtrack(int[] nums, List<List<Integer>> output, List<Integer> tempList, int start) {
        output.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, output, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
