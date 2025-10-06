package third;
/*
Given an array arr[] of size n, the task is to find the length of the Longest Increasing Subsequence (LIS) i.e., the longest possible subsequence in which the elements of the subsequence are sorted in increasing order.

Examples:

Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest increasing subsequence is 3, 10, 20

Input: arr[] = [30, 20, 10]
Output:1
Explanation: The longest increasing subsequences are [30], [20] and [10]

Input: arr[] = [2, 2, 2]
Output: 1
Explanation:  We consider only strictly increasing.

Input: arr[] = [10, 20, 35, 80]
Output: 4
Explanation: The whole array is sorted
*/

import java.util.Arrays;

public class ProblemDSA86 {
    public static void main(String[] args) {
        SolutionDSA86 solution = new SolutionDSA86();
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

        System.out.println(solution.longestIncreasingSubsequence(arr));
    }
}

class SolutionDSA86 {

    public int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, lis[i]);
        }

        return max;
    }
}

