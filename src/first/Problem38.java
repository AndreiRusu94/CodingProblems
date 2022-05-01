package first;
/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

    Example 1:

      Input: candidates = [2,3,6,7], target = 7,
      A solution set is:
      [
        [7],
        [2,2,3]
      ]
 */


import java.util.ArrayList;
import java.util.List;

public class Problem38 {
    public static void main(String[] args) {
        Solution38 solution = new Solution38();

        int[] candidates = {2, 3, 6, 7};

        System.out.println(solution.combinationSum(candidates, 7));
    }
}

class Solution38 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();

        backtrack(output, new ArrayList<>(), candidates, target, 0);

        return output;
    }

    private void backtrack(List<List<Integer>> output, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain == 0) {
            output.add(new ArrayList<>(tempList));
        } else if (remain > 0){
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(output, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}