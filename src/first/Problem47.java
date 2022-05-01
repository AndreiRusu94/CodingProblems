package first;
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

  Example:

    Input: [1,1,2]
    Output:
    [
      [1,1,2],
      [1,2,1],
      [2,1,1]
    ]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem47 {
    public static void main(String[] args) {
        Solution47 solution = new Solution47();

        int[] candidates = {1, 1, 2};

        System.out.println(solution.permuteUnique(candidates));
    }
}

class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);
        backtrack(nums, output, new ArrayList<>(), new boolean[nums.length]);

        return output;
    }

    private void backtrack(int[] nums, List<List<Integer>> output, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            output.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                    continue;
                }

                used[i] = true;
                tempList.add(nums[i]);
                backtrack(nums, output, tempList, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}