package third;
/*
Given an integer array arr[], the task is to count the number of subarrays in arr[] that are strictly increasing and have a size of at least 2. A subarray is a contiguous sequence of elements from arr[]. A subarray is strictly increasing if each element is greater than its previous element.

Examples:

Input: arr[] = [1, 4, 5, 3, 7, 9]
Output: 6
Explanation: The strictly increasing subarrays are: [1, 4], [1, 4, 5], [4, 5], [3, 7], [3, 7, 9], [7, 9]

Input: arr[] = [1, 3, 3, 2, 3, 5]
Output: 4
Explanation: The strictly increasing subarrays are: [1, 3], [2, 3], [2, 3, 5], [3, 5]

Input: arr[] = [2, 2, 2, 2]
Output: 0
Explanation: No strictly increasing subarray exists.
*/

public class ProblemDSA7 {
    public static void main(String[] args) {
        SolutionDSA7 solution = new SolutionDSA7();
        int[] arr = new int[]{1, 4, 5, 3, 7, 9};
        System.out.println(solution.countIncreasing(arr));
    }
}

class SolutionDSA7 {

    public int countIncreasing(int[] arr) {
        int count = 0;
        int n = arr.length;
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
            } else {
                count += len * (len - 1) / 2;
                len = 1;
            }
        }

        count += len * (len - 1) / 2;
        return count;
    }

}
