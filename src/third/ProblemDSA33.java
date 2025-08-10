package third;

/*
Given a row-wise sorted matrix mat[][] of order n * m, where the number of rows and columns are always odd. The task is to find the median of the matrix.

Note: Median is the middle number in a sorted ascending or descending list of numbers. In case of an even number of elements return the left median.

Examples:

Input: mat[][] =  [[1 3 5],
                              [2 6 9],
                              [3 6 9]]
Output: 5
Explanation: Elements in sorted order: 1 2 3 3 5 6 6 9 9. There are total 9 elements, thus the median is the element at index 5 (1-based) i.e. 5.

Input: mat[][] = [[1 3 4],
                              [2 5 6]
                              [3 7 9]]
Output: 4
Explanation: Elements in sorted order: 1 2 3 3 4 5 6 7 9. There are total 9 elements, thus the median is the element at index 5 (1-based) i.e. 4.
*/

public class ProblemDSA33 {

    public static void main(String[] args) {
        SolutionDSA33 solution = new SolutionDSA33();
        int[][] mat = {
                {1, 3, 4},
                {2, 5, 6},
                {3, 7, 9}
        };

        System.out.println(solution.median(mat));
    }
}

class SolutionDSA33 {

    public int median(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] counts = new int[n];

        int count = 0;
        int medianCount = (n * m + 1) / 2;
        int median = matrix[0][0];

        while (count < medianCount) {
            int mini = Integer.MAX_VALUE;
            int minIndex = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (counts[i] < m) {
                    if (matrix[i][counts[i]] < mini) {
                        mini = matrix[i][counts[i]];
                        minIndex = i;
                    }
                }
            }

            counts[minIndex]++;
            count++;
            median = mini;
        }

        return median;
    }

}