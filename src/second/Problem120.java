package second;
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
        List<Integer> currentRow = triangle.get(triangleSize - 1);

        for (int i = triangleSize - 2; i >= 0; i--) {
            List<Integer> prevRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                prevRow.set(j, Math.min(currentRow.get(j), currentRow.get(j + 1)) + prevRow.get(j));
            }

            currentRow = triangle.get(i);
        }

        return currentRow.get(0);
    }
}
