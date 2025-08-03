package third;
/*
Given an array arr[] of size n, the task is to return an equilibrium index (if any) or -1 if no equilibrium index exists. The equilibrium index of an array is an index such that the sum of all elements at lower indexes equals the sum of all elements at higher indexes.

Note: When the index is at the start of the array, the left sum is 0, and when it's at the end, the right sum is 0.

Examples:

Input: arr[] = [1, 2, 0, 3]
Output: 2
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 3.

Input: arr[] = [1, 1, 1, 1]
Output: -1
Explanation: There is no equilibrium index in the array.

Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.

*/

public class ProblemDSA13 {
    public static void main(String[] args) {
        SolutionDSA13 solution = new SolutionDSA13();
        System.out.println(solution.findEquilibrium(new int[]{-7, 1, 5, 2, -4, 3, 0}));
    }
}

class SolutionDSA13 {

    public int findEquilibrium(int[] arr) {
        int n = arr.length;
        int total = 0, prefix = 0;

        for (var e : arr) {
            total += e;
        }

        for (int i = 0; i < n; i++) {
            int suffSum = total - prefix - arr[i];
            if (suffSum == prefix) {
                return i;
            }

            prefix += arr[i];
        }


        return -1;
    }

}
