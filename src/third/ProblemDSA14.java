package third;
/*
Given an array arr[] of n integers, construct a product array res[] (of the same size) such that res[i] is equal to the product of all the
elements of arr[] except arr[i].

Example:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation:

For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
Input: arr[] = [12, 0]
Output: [0, 12]
Explanation:

For i = 0, res[i] = 0.
For i = 1, res[i] = 12.

*/

import java.util.Arrays;

public class ProblemDSA14 {
    public static void main(String[] args) {
        SolutionDSA14 solution = new SolutionDSA14();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{10, 3, 5, 0, 6, 2})));
    }
}

class SolutionDSA14 {

    public int[] productExceptSelf(int[] arr) {
        int prod = 1, zeros = 0, zeroIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros++;
                zeroIndex = i;
            } else {
                prod *= arr[i];
            }
        }

        int[] output = new int[arr.length];
        Arrays.fill(output, 0);

        if (zeros == 0) {
            for (int i = 0; i < arr.length; i++) {
                output[i] = prod / arr[i];
            }
        }

        if (zeros == 1) {
            output[zeroIndex] = prod;
        }

        return output;
    }

}
