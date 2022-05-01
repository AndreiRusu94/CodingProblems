package first;
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

  Example 1:
    Input: ["flower","flow","flight"]
    Output: "fl"

  Example 2:
    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
 */

import java.util.*;

public class Problem15 {
    public static void main(String[] args) {
        Solution15 solution = new Solution15();

        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(input));
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        if (nums == null || nums.length == 0 || nums.length < 3) {
            return output;
        }

        Arrays.sort(nums);

        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -nums[i] - nums[j];

                if (numToIndex.get(target) != null && numToIndex.get(target) > j) {
                    output.add(Arrays.asList(nums[i], nums[j], target));
                    j = numToIndex.get(nums[j]);
                }

                i = numToIndex.get(nums[i]);
            }
        }

        return output;
    }
}