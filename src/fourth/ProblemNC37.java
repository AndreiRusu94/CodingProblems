package fourth;
/*
You are given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k,
otherwise return false.

Example 1:

Input: nums = [1,2,3,1], k = 3

Output: true
Example 2:

Input: nums = [2,1,2], k = 1

Output: false

*/

import java.util.HashSet;
import java.util.Set;

public class ProblemNC37 {
    public static void main(String[] args) {
        SolutionNC37 solution = new SolutionNC37();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}

class SolutionNC37 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Set<Integer> valuesInWindow = new HashSet<>();

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r - l > k) {
                valuesInWindow.remove(nums[l]);
                l++;
            }

            if (valuesInWindow.contains(nums[r])) {
                return true;
            }

            valuesInWindow.add(nums[r]);
        }

        return false;
    }

}

