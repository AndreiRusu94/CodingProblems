/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

  Example:

    Input: 3
    Output: [1,3,3,1]
*/

import java.util.ArrayList;
import java.util.List;

public class Problem119 {
    public static void main(String[] args) {
        Solution119 solution = new Solution119();

        System.out.println(solution.getRow(5));
    }
}

class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        row.add(1);
        List<Integer> prevRow;

        for (int i = 1; i <= rowIndex; i++) {
            prevRow = new ArrayList<>(row);
            row = new ArrayList<>();
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1);
        }

        return row;
    }
}
