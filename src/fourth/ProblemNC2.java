package fourth;
/*
You are given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

Example 1:
Input: arr = [2,4,5,3,1,2]
Output: [5,5,3,2,2,-1]

Example 2:
Input: arr = [3,3]
Output: [3,-1]
*/

import java.util.Arrays;

public class ProblemNC2 {
    public static void main(String[] args) {
        SolutionNC2 solution = new SolutionNC2();

        System.out.println(Arrays.toString(solution.replaceElements(new int[]{2, 4, 5, 3, 1, 2})));
    }
}

class SolutionNC2 {
    public int[] replaceElements(int[] arr) {
        int rightMax = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = rightMax;
            rightMax = Math.max(tmp, rightMax);
        }

        return arr;
    }
}
