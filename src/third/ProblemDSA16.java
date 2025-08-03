package third;
/*
Given an array arr[] of positive and negative integers, the objective is to find the number of subarrays having a sum exactly equal to a given number k.

Examples:

Input : arr[] = [10, 2, -2, -20, 10], k = -10
Output : 3
Explanation: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum equal to -10.

Input : arr[] = [9, 4, 20, 3, 10, 5], k = 33
Output : 2
Explanation: Subarrays: arr[0...2], arr[2...4] have sum equal to 33.

Input : arr[] = [1, 3, 5], k = 2
Output : 0
Explanation: No subarrays with 0 sum.
*/

import java.util.HashMap;
import java.util.Map;

public class ProblemDSA16 {
    public static void main(String[] args) {
        SolutionDSA16 solution = new SolutionDSA16();
        System.out.println(solution.cntSubarrays(new int[]{10, 2, -2, -20, 10}, -10));
    }
}

class SolutionDSA16 {

    public int cntSubarrays(int[] arr, int k) {
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int currSum = 0, count = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == k) {
                count++;
            }

            if (prefixSums.containsKey(currSum - k)) {
                count += prefixSums.get(currSum - k);
            }

            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }

}
