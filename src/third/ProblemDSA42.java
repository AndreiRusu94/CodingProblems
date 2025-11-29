package third;
/*
Given an array arr[], for each element, find the nearest element to its right that has a higher frequency than the current element.
If no such element exists, set the value to -1.

Examples:

Input: arr[] = [2, 1, 1, 3, 2, 1]
Output: [1, -1, -1, 2, 1, -1]
Explanation: Frequencies: 1 → 3 times, 2 → 2 times, 3 → 1 time.
 For arr[0] = 2, the next element 1 has a higher frequency → 1.
 For arr[1] and arr[2] (1), no element to the right has a higher frequency → -1.
 For arr[3] = 3, the next 2 has a higher frequency → 2.
 For arr[4] = 2, the next 1 has a higher frequency → 1.
 For arr[5] = 1, no elements to the right → -1.

Input: arr[] = [1, 2, 1]
Output: [-1, 1, -1]
Explanation: Frequencies: 1→2, 2→1.
 2→1 (higher freq), others have no higher freq on right → [-1, 1, -1]
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ProblemDSA42 {
    public static void main(String[] args) {
        SolutionDSA42 solution = new SolutionDSA42();

        System.out.println(Arrays.toString(solution.findGreater(new int[]{2, 1, 1, 3, 2, 1})));
    }
}

class SolutionDSA42 {
    public int[] findGreater(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int e : arr) {
            freq.put(e, freq.getOrDefault(e, 0) + 1);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] output = new int[arr.length];
        Arrays.fill(output, -1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && freq.get(arr[i]) > freq.get(arr[stack.peek()])) {
                output[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return output;
    }


}