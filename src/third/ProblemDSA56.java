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
import java.util.PriorityQueue;

public class ProblemDSA56 {
    public static void main(String[] args) {
        SolutionDSA56 solution = new SolutionDSA56();

        int[][] arr = {
                {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}
        };

        System.out.println(solution.mergeKArrays(arr, arr.length));
    }
}

class SolutionDSA56 {

    private class Node implements Comparable<Node> {
        int i, j, val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.val, other.val);
        }
    }

    public List<Integer> mergeKArrays(int[][] arr, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            minHeap.add(new Node(i, 0, arr[i][0]));
        }

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            output.add(curr.val);

            if (curr.j + 1 < arr[curr.i].length) {
                minHeap.add(new Node(curr.i, curr.j + 1, arr[curr.i][curr.j + 1]));
            }
        }

        return output;
    }

}