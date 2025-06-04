package second;

/*
You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can be defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

Example 1:

Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
Output: 12
Explanation:
The four possible subsequence scores are:
- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
Therefore, we return the max score, which is 12.
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem2542 {

    public static void main(String[] args) {
        Solution2542 solution = new Solution2542();
        System.out.println(solution.maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));

    }
}

class Solution2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length = nums1.length;
        int[][] indices = new int[length][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);

        for (int i = 0; i < length; i++) {
            indices[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(indices, (a, b) -> b[0] - a[0]);

        long output = 0, currentSum = 0;
        for (int[] pair : indices) {
            pq.add(pair[1]);
            currentSum += pair[1];

            if (pq.size() > k) {
                currentSum -= pq.poll();
            }

            if (pq.size() == k) {
                output = Math.max(output, (currentSum * pair[0]));
            }
        }

        return output;
    }
}