package first;
/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

  Example 1:

    Input: [2,2,3,2]
    Output: 3

  Example 2:

    Input: [0,1,0,1,0,1,99]
    Output: 99
*/

import java.util.HashMap;
import java.util.Map;

public class Problem137 {
    public static void main(String[] args) {
        Solution137 solution = new Solution137();

        int[] nums = {1, 2, 2, 2, 4, 4, 4};
        System.out.println(solution.singleNumber(nums));
    }
}

class Solution137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numAppearence = new HashMap<>();

        for (int num : nums) {
            numAppearence.put(num, numAppearence.getOrDefault(num, 0) + 1);
        }

        return numAppearence.entrySet()
                .stream()
                .filter(n -> n.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }
}
