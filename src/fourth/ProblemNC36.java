package fourth;
/*
You are given an array prerequisites where prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a.

The pair [0, 1], indicates that must take course 1 before taking course 0.

There are a total of numCourses courses you are required to take, labeled from 0 to numCourses - 1.

Return true if it is possible to finish all courses, otherwise return false.

Example 1:

Input: numCourses = 2, prerequisites = [[0,1]]

Output: true
Explanation: First take course 1 (no prerequisites) and then take course 0.

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProblemNC36 {
    public static void main(String[] args) {
        SolutionNC36 solution = new SolutionNC36();
        System.out.println(solution.canFinish(2, new int[][]{{0, 1}}));
    }
}

class SolutionNC36 {

    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visited.contains(course)) {
            return false;
        }

        if (preMap.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }

}

