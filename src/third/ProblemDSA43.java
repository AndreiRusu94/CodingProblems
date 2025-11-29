package third;
/*
Given an array of integers, the task is to find the maximum absolute difference between the nearest left and the right smaller element of every
element in the array.

Note: If there is no smaller element on right side or left side of any element then we take zero as the smaller element. For example for the
leftmost element, the nearest smaller element on the left side is considered as 0. Similarly, for rightmost elements, the smaller element on the
right side is considered as 0.

Examples:

Input: arr[] = [2, 1, 8]
Output: 1
Explanation: Left smaller  ls[] = [0, 0, 1], Right smaller rs[] = [1, 0, 0]
Maximum Diff of abs(ls[i] - rs[i]) = 1

Input: arr[] = [2, 4, 8, 7, 7, 9, 3]
Output: 4
Explanation: Left smaller  ls[] = [0, 2, 4, 4, 4, 7, 2], Right smaller  rs[] = [0, 3, 7, 3, 3, 3, 0]
Maximum Diff of abs(ls[i] - rs[i]) = 7 - 3 = 4
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ProblemDSA43 {
    public static void main(String[] args) {
        SolutionDSA43 solution = new SolutionDSA43();

        System.out.println(solution.findMaxDiff(new int[]{2, 4, 8, 7, 7, 9, 3}));
    }
}

class SolutionDSA43 {
    public int findMaxDiff(int[] arr) {
        int n = arr.length;
        int[] diff = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(diff, 0);
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                diff[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                Integer pos = stack.pop();
                diff[pos] = arr[i] - diff[pos];
                if (maxi < diff[pos]) {
                    maxi = diff[pos];
                }
            }
            stack.push(i);
        }

        return maxi;
    }


}