package fourth;
/*
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

Input: nums = [1, 2, 3, 3]

Output: true

*/

import java.util.HashSet;
import java.util.Set;

public class ProblemNC23 {
    public static void main(String[] args) {
        SolutionNC23 solution = new SolutionNC23();

        System.out.println(solution.hasDuplicate(new int[]{1, 2, 3, 3}));
    }

}

class SolutionNC23 {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>();

        for (int num : nums) {
            if (values.contains(num)) {
                return true;
            }

            values.add(num);
        }

        return false;
    }
}