package third;
/*
Given two binary arrays a1[] and a2[] of equal length, find the maximum length of a subarray [i...j] such that the sum of elements from i to j in both arrays is equal, i.e.,
a1[i] + a1[i+1] + ... + a1[j] == a2[i] + a2[i+1] + ... + a2[j].

Examples:

Input: a1[] = [0, 1, 0, 0, 0, 0], a2[] = [1, 0, 1, 0, 0, 1]
Output: 4
Explanation: The longest span with same sum is from index 1 to 4.

Input: a1[] = [0, 1, 0, 1, 1, 1, 1], a2[] = [1, 1, 1, 1, 1, 0, 1]
Output: 6
Explanation: The longest span with same sum is from index 1 to 6.

Input: a1[] = [0, 0, 0], a2[] = [1, 1, 1]
Output: 0
Explanation: There is no span where the sum of the elements in a1[] and a2[] is equal.
*/

import java.util.Arrays;

public class ProblemDSA15 {
    public static void main(String[] args) {
        SolutionDSA15 solution = new SolutionDSA15();
        System.out.println(solution.equalSumSpan(new int[]{0, 1, 0, 0, 0, 0}, new int[]{1, 0, 1, 0, 0, 1}));
    }
}

class SolutionDSA15 {

    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length, maxLen = 0;
        int[] diff = new int[2 * n + 1];

        Arrays.fill(diff, -1);

        int prefix1 = 0, prefix2 = 0;
        for (int i = 0; i < n; i++) {
            prefix1 += a1[i];
            prefix2 += a2[i];

            int currentDiff = prefix1 - prefix2;
            int index = currentDiff + n;

            if (currentDiff == 0) {
                maxLen = Math.max(maxLen, i + 1);
            } else if (diff[index] != -1) {
                maxLen = Math.max(maxLen, i - diff[index]);
            } else {
                diff[index] = i;
            }
        }

        return maxLen;
    }

}
