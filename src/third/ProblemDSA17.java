package third;
/*
Given an array arr[] and an integer k, the task is to count all subarrays whose sum is divisible by k.

Examples:

Input: arr[] = [4, 5, 0, -2, -3, 1], k = 5
Output: 7
Explanation: There are 7 subarrays whose sum is divisible by 5: [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3] and [-2, -3].

Input: arr[] = [2, 2, 2, 2, 2, 2], k = 2
Output: 21
Explanation: All subarray sums are divisible by 2.

Input: arr[] = [-1, -3, 2], k = 5
Output: 0
Explanation: There is no subarray whose sum is divisible by k.
*/

import java.util.HashMap;
import java.util.Map;

public class ProblemDSA17 {
    public static void main(String[] args) {
        SolutionDSA17 solution = new SolutionDSA17();
        System.out.println(solution.subCount(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}

class SolutionDSA17 {

    public int subCount(int[] arr, int k) {
        Map<Integer, Integer> prefCnt = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = ((sum + arr[i]) % k + k) % k;

            if (sum == 0) {
                count++;
            }

            count += prefCnt.getOrDefault(sum, 0);

            prefCnt.put(sum, prefCnt.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
