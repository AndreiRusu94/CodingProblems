package first;
/*
Given a collection of distinct integers, return all possible permutations.

  Example:

    Input: [1,2,3]
    Output:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
 */


import java.util.ArrayList;
import java.util.List;

public class Problem46 {
    public static void main(String[] args) {
        Solution46 solution = new Solution46();

        int[] candidates = {1, 2, 3, 4};

        System.out.println(solution.permute(candidates));
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        backtrack(nums, output, new ArrayList<>());

        return output;
    }

    private void backtrack(int[] nums, List<List<Integer>> output, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            output.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }

                tempList.add(nums[i]);
                backtrack(nums, output, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}