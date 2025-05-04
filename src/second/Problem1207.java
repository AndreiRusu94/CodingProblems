package second;

/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1207 {

    public static void main(String[] args) {
        Solution1207 solution = new Solution1207();
        System.out.println(solution.uniqueOccurrences(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> valueToOcc = new HashMap<>();
        Set<Integer> values = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            valueToOcc.compute(arr[i], (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (Integer value : valueToOcc.values()) {
            if (values.contains(value)) {
                return false;
            }

            values.add(value);
        }

        return true;
    }
}
