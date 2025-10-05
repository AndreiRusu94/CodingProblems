package third;
/*
Given length of wall w and shelves of two lengths m and n, find the number of each type of shelf to be used and the remaining empty space in the
optimal solution so that the empty space is minimum. The larger of the two shelves is cheaper so it is preferred. However cost is secondary and
first priority is to minimize empty space on wall.

Examples:

Input : w = 24 m = 3 n = 5
Output : 3 3 0
We use three units of both shelves
and 0 space is left.
3 * 3 + 3 * 5 = 24
So empty space  = 24 - 24 = 0
Another solution could have been 8 0 0
but since the larger shelf of length 5
is cheaper the former will be the answer.

Input : w = 29 m = 3 n = 9
Output : 0 3 2
0 * 3 + 3 * 9 = 27
29 - 27 = 2

Input : w = 24 m = 4 n = 7
Output : 6 0 0
6 * 4 + 0 * 7 = 24
24 - 24 = 0
*/

import java.util.List;

public class ProblemDSA83 {
    public static void main(String[] args) {
        SolutionDSA83 solution = new SolutionDSA83();

        int wall = 24, m = 6, n = 5;
        System.out.println(solution.minSpacePreferLarge(wall, m, n));

        m = 7;
        n = 3;
        System.out.println(solution.minSpacePreferLarge(wall, m, n));
    }
}

class SolutionDSA83 {

    public List<Integer> minSpacePreferLarge(int wall, int m, int n) {
        int minUnused = wall, bestM = 0, bestN = 0;
        for (int i = 0; i <= wall / m; i++) {
            int remaining = wall - i * m;
            int j = remaining / n;

            int used = i * m + j * n;
            int unused = wall - used;
            if (unused <= minUnused) {
                minUnused = unused;
                bestM = i;
                bestN = j;
            }
        }

        return List.of(minUnused, bestM, bestN);
    }
}

