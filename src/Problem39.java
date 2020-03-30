/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

    Example 1:

      Input: candidates = [10,1,2,7,6,1,5], target = 8,
        A solution set is:
        [
            [1, 7],
            [1, 2, 5],
            [2, 6],
            [1, 1, 6]
        ]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39 {
    public static void main(String[] args) {
        Solution39 solution = new Solution39();

        int[] candidates = {2, 3, 6, 7};

        System.out.println(solution.combinationSum2(candidates, 7));
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> output = new ArrayList<>();
        backtrack(candidates, output, new ArrayList<>(), target, 0);

        return output;
    }

    private void backtrack(int[] candidates, List<List<Integer>> output, List<Integer> tempList, int remain, int start) {
        if (remain == 0) {
            output.add(new ArrayList<>(tempList));
        } else {
            if (remain > 0) {
                for (int i = start; i < candidates.length; i++) {
                    if (i > start && candidates[i] == candidates[i-1]) {
                        continue;
                    }

                    tempList.add(candidates[i]);
                    backtrack(candidates, output, tempList, remain - candidates[i], i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }

    }
}