package third;
/*
Given an integer array arr[] of size n and an integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.

Examples:

Input: arr[] = [ 8, 4, 2, 6, 7 ], x = 4
Output: [ 4, 2, 6 ]
Explanation: The sub-array described by index [1, 3], i.e., [ 4, 2, 6 ] contains no such difference of two elements which is greater than 4.

Input: arr[] = [ 15, 10, 1, 2, 4, 7, 2 ], x = 5
Output: [ 2, 4, 7, 2 ]
Explanation: The sub-array described by indexes [3, 6], i.e., [ 2, 4, 7, 2 ] contains no such difference of two elements which is greater than 5.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ProblemDSA50 {
    public static void main(String[] args) {
        SolutionDSA50 solution = new SolutionDSA50();

        System.out.println(solution.longestSubarray(new int[]{15, 10, 1, 2, 4, 7, 2}, 5));
    }
}

class SolutionDSA50 {
    public List<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();

        int start = 0, end = 0;
        int resStart = 0, resEnd = 0;
        while (end < n) {
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end]) {
                minQueue.pollLast();
            }

            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end]) {
                maxQueue.pollLast();
            }

            minQueue.addLast(end);
            maxQueue.addLast(end);

            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                if (start == minQueue.peekFirst()) {
                    minQueue.pollFirst();
                }

                if (start == maxQueue.peekFirst()) {
                    maxQueue.pollFirst();
                }

                start += 1;
            }

            if (resEnd - resStart < end - start) {
                resEnd = end;
                resStart = start;
            }

            end += 1;
        }

        for (int i = resStart; i <= resEnd; i++) {
            output.add(arr[i]);
        }

        return output;
    }


}