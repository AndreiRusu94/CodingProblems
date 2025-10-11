package third;
/*
Given three arrays height[], width[], and length[] of size n, where height[i], width[i], and length[i] represent the dimensions of a box. The
task is to create a stack of boxes that is as tall as possible, but we can only stack a box on top of another box if the dimensions of the 2-D
base of the lower box are each strictly larger than those of the 2-D base of the higher box.

Note:

We can rotate a box so that any side functions as its base.
It is also allowable to use multiple instances of the same type of box.
The base of the lower box should be strictly larger than that of the new box we're going to place. This is in terms of both length and width,
not just in terms of area. So, two boxes with the same base cannot be placed one over the other.
Example:

Input: height[] = [4, 1, 4, 10], width[] = [6, 2, 5, 12], length[] = [7, 3, 6, 32]
Output: 60
Explanation: One way of placing the boxes is as follows in the bottom to top manner: (Denoting the boxes in (l, w, h) manner)
(12, 32, 10) (10, 12, 32) (6, 7, 4)
(5, 6, 4) (4, 5, 6) (2, 3, 1) (1, 2, 3)
Hence, the total height of this stack is 10 + 32 + 4 + 4 + 6 + 1 + 3 = 60.
No other combination of boxes produces a height greater than this.

Input: height[] = [1, 4, 3], width[] = [2, 5, 4], length[] = [3, 6, 1]
Output: 15
Explanation: One way of placing the boxes is as follows in the bottom to top manner: (Denoting the boxes in (l, w, h) manner)
(5, 6, 4) (4, 5, 6) (3, 4, 1), (2, 3, 1)
(1, 2, 3).
Hence, the total height of this stack is 4 + 6 + 1 + 1 + 3 = 15
No other combination of boxes produces a height greater than this.

*/

import java.util.ArrayList;
import java.util.List;

public class ProblemDSA93 {
    public static void main(String[] args) {
        SolutionDSA93 solution = new SolutionDSA93();

        int[] height = {4, 1, 4, 10};
        int[] width = {6, 2, 5, 12};
        int[] length = {7, 3, 6, 32};

        System.out.println(solution.maxHeight(height, width, length));
    }
}

class SolutionDSA93 {

    public int maxHeight(int[] height, int[] width, int[] length) {
        List<int[]> boxes = new ArrayList<>();
        int n = height.length;

        for (int i = 0; i < n; i++) {
            int a = height[i], b = width[i], c = length[i];
            boxes.add(new int[]{a, b, c});
            boxes.add(new int[]{a, c, b});
            boxes.add(new int[]{b, a, c});
            boxes.add(new int[]{b, c, a});
            boxes.add(new int[]{c, a, b});
            boxes.add(new int[]{c, b, a});
        }

        boxes.sort((x, y) -> x[0] != y[0] ? y[0] - x[0] : y[1] - x[1]);

        int[] dp = new int[boxes.size()];
        int ans = 0;
        for (int i = boxes.size() - 1; i >= 0; i--) {
            dp[i] = boxes.get(i)[2];

            for (int j = i; j < boxes.size(); j++) {
                if (boxes.get(i)[0] > boxes.get(j)[0] && boxes.get(i)[1] > boxes.get(j)[1]) {
                    dp[i] = Math.max(dp[i], boxes.get(i)[2] + dp[j]);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

}

