package third;
/*
You are given a sorted array arr[] containing unique integers, a number k, and a target value x. Your goal is to return exactly k elements from the
 rray that are closest to x, excluding x itself if it is present in the array.

An element a is closer to x than b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)
Examples:

Input: arr[] = [12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56], k = 4, x = 35
Output: 39 30 42 45
Explanation: First closest element to 35 is 39.
Second closest element to 35 is 30.
Third closest element to 35 is 42.
And fourth closest element to 35 is 45.

Input: arr[] = [1, 3, 4, 10, 12], k = 2, x = 4
Output: 3 1
Explanation: 4 is excluded, Closest elements to 4 are: 3 (1), 1 (3). So, the 2 closest elements are: 3 1

https://www.geeksforgeeks.org/dsa/find-k-closest-elements-given-value/
*/

import java.util.Arrays;

public class ProblemDSA1 {
    public static void main(String[] args) {
        SolutionDSA1 solution = new SolutionDSA1();
        System.out.println(Arrays.toString(solution.printKClosest(new int[]{12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}, 4, 35)));
    }
}

class SolutionDSA1 {
    public int[] printKClosest(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        int pos = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                pos = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = pos;
        right = pos + 1;
        int n = arr.length - 1;

        if (right < n && arr[right] == x) {
            right++;
        }

        int count = 0;
        int[] output = new int[k];

        while (left >= 0 && right < n && count < k) {
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);

            if (leftDiff < rightDiff) {
                output[count++] = arr[left--];
            } else {
                output[count++] = arr[right++];
            }
        }

        while (left >= 0 && count < k) {
            output[count++] = arr[left--];
        }

        while (right < n && count < k) {
            output[count++] = arr[right++];
        }

        return output;
    }

}
