package third;
/*
3 Sum – All Distinct Triplets with given Sum in an Array

Given an array arr[], and an integer target, find all possible unique triplets in the array whose sum is equal to the given target value. We can 
return triplets in any order, but all the returned triplets should be internally sorted, i.e., for any triplet [q1, q2, q3], 
the condition q1 ≤ q2 ≤ q3 should hold.

Examples:

Input: arr[] = {12, 3, 6, 1, 6, 9}, target = 24
Output: {{3, 9, 12}, {6, 6, 12}}
Explanation: There are two unique triplets that add up to 24:
3 + 9 + 12 = 24
6 + 6 + 12 = 24

Input: arr[] = {-2, 0, 1, 1, 2}, target = 10
Output: {}
Explanation: There is not triplet with sum 10.

https://www.geeksforgeeks.org/dsa/unique-triplets-sum-given-value/#expected-approach-using-two-pointers-technique-on2-time-and-o1-space
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemDSA4 {
    public static void main(String[] args) {
        SolutionDSA4 solution = new SolutionDSA4();
        int[] arr = new int[]{12, 3, 6, 1, 6, 9};
        System.out.println(solution.threeSum(arr, 24));
    }
}

class SolutionDSA4 {

    public List<List<Integer>> threeSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) {
                    output.add(List.of(arr[i], arr[left], arr[right]));
                    left++;
                    right--;

                    while (left < n && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (right > left && arr[right] == arr[right + 1]) {
                        right++;
                    }
                } else {
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return output;
    }

}
