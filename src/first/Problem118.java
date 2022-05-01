package first;
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

  Example:

    Input: 5
    Output:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
*/

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    public static void main(String[] args) {
        Solution118 solution = new Solution118();

        System.out.println(solution.generate(5));
    }
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            List<Integer> prevRow = triangle.get(rowNum - 1);

            for (int i = 1; i < rowNum; i++) {
                row.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            row.add(1);
            triangle.add(row);
        }

        return triangle;
    }
}
