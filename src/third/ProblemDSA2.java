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

public class ProblemDSA2 {
    public static void main(String[] args) {
        SolutionDSA2 solution = new SolutionDSA2();
        int[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        solution.mergeSort(arr, 0, arr.length - 1);
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}

class SolutionDSA2 {
    public void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i++];
            } else {
                arr[k] = R[j++];
            }
            k++;
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }

    }

}
