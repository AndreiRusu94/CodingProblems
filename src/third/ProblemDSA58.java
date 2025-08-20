package third;
/*
Given a 2D matrix arr[][] consisting of K sorted arrays, where each row is sorted in non-decreasing order, find a single sorted array that contains all the elements from the matrix.

Examples:

Input: k = 3, arr[][] = [[1, 3, 5, 7], [2, 4, 6, 8], [0, 9, 10, 11]]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Explanation: Merging all elements from the 3 sorted arrays and sorting them results in: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Input: k = 4, arr[][] = [[1, 2, 3, 4], [2, 2, 3, 4], [5, 5, 6, 6], [7, 8, 9, 9]]
Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
Explanation: Merging all elements from the 4 sorted arrays and sorting them results in: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9] .

Time Complexity: O(n*log(k)), where n is total number of elements in all input arrays.
Auxiliary Space: O(n).

*/

import java.util.ArrayList;
import java.util.List;

public class ProblemDSA58 {
    public static void main(String[] args) {
        SolutionDSA58 solution = new SolutionDSA58();

        int[][] arr = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        System.out.println(solution.mergeKArrays(arr, arr.length));
    }
}

class SolutionDSA58 {

    public List<Integer> mergeKArrays(int[][] arr, int k) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int[] row : arr) {
            List<Integer> list = new ArrayList<>();

            for (int e : row) {
                list.add(e);
            }

            lists.add(list);
        }

        return mergeK(lists, 0, k - 1);
    }

    private List<Integer> mergeK(List<List<Integer>> lists, int i, int j) {
        if (i == j) {
            return lists.get(i);
        }

        int mid = i + (j - i) / 2;
        List<Integer> left = mergeK(lists, i, mid);
        List<Integer> right = mergeK(lists, mid + 1, j);

        return mergeArrays(left, right);
    }

    private List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if(a.get(i) < b.get(j)) {
                mergedList.add(a.get(i++));
            } else {
                mergedList.add(b.get(j++));
            }
        }

        while (i < a.size()) {
            mergedList.add(a.get(i++));
        }

        while (j < b.size()) {
            mergedList.add(b.get(j++));
        }

        return mergedList;
    }

}