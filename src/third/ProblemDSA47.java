package third;
/*
Given an array arr[] of integers and an integer k, your task is to find the maximum value for each contiguous subarray of size k. The output should be an array of maximum values corresponding to each contiguous subarray.

Examples :

Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
Output: [3, 3, 4, 5, 5, 5, 6]
Explanation:
1st contiguous subarray = [1 2 3] max = 3
2nd contiguous subarray = [2 3 1] max = 3
3rd contiguous subarray = [3 1 4] max = 4
4th contiguous subarray = [1 4 5] max = 5
5th contiguous subarray = [4 5 2] max = 5
6th contiguous subarray = [5 2 3] max = 5
7th contiguous subarray = [2 3 6] max = 6

Input: arr[] = [5, 1, 3, 4, 2, 6], k = 1
Output: [5, 1, 3, 4, 2, 6]
Explanation: When k = 1, each element in the array is its own subarray, so the output is simply the same array.

Input: arr[] = [1, 3, 2, 1, 7, 3], k = 3
Output: [3, 3, 7, 7]
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ProblemDSA47 {
    public static void main(String[] args) {
        SolutionDSA47 solution = new SolutionDSA47();

        System.out.println(solution.maxOfSubarrays(new int[]{1, 3, 2, 1, 7, 3}, 3));
    }
}

class SolutionDSA47 {
    public List<Integer> maxOfSubarrays(int[] arr, int k) {
        List<Integer> output = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }

        for (int i = k; i < arr.length; i++) {
            output.add(arr[dq.peekFirst()]);

            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.addLast(i);
        }

        output.add(arr[dq.peekFirst()]);
        return output;
    }


}