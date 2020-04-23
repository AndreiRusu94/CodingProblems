/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

  For example, given the following triangle

    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem120 {
    public static void main(String[] args) {
        Solution120 solution = new Solution120();

        List<List<Integer>> triangle = new ArrayList<>();

        Integer[] nums = new Integer[10];
        nums[0] = 2;

        List<Integer> row = Arrays.asList(nums);
        triangle.add(new ArrayList<>(row));

        nums[0] = 3;
        nums[1] = 4;

        row = Arrays.asList(nums);
        triangle.add(new ArrayList<>(row));

        nums[0] = 6;
        nums[1] = 5;
        nums[2] = 7;

        row = Arrays.asList(nums);
        triangle.add(new ArrayList<>(row));


        System.out.println(solution.minimumTotal(triangle));
    }
}

class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int triangleSize = triangle.size();

        List<Integer> row = triangle.get(0);
        List<Integer> prevRow;

        int minimumPath = triangle.size() > 1 ? Integer.MAX_VALUE : row.get(0);

        for (int rowNum = 1; rowNum < triangleSize; rowNum++) {
            prevRow = new ArrayList<>(row);

            row = triangle.get(rowNum);

            row.set(0, prevRow.get(0) + row.get(0));

            for (int i = 1; i < rowNum; i++) {
                int prev = prevRow.get(i - 1);
                int current = prevRow.get(i);

                row.set(i, prev > current ? row.get(i) + current : row.get(i) + prev);

                if (rowNum == triangleSize - 1) {
                    if (row.get(i) < minimumPath) {
                        minimumPath = row.get(i);
                    }
                }
            }

            row.set(rowNum, prevRow.get(rowNum - 1) + row.get(rowNum));

            if (rowNum == triangleSize - 1) {
                if (row.get(0) < minimumPath) {
                    minimumPath = row.get(0);
                }

                if (row.get(rowNum) < minimumPath) {
                    minimumPath = row.get(rowNum);
                }
            }
        }

        return minimumPath;
    }
}
