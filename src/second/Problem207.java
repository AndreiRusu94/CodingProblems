package second;
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/


import java.util.ArrayList;
import java.util.List;

public class Problem207 {
    public static void main(String[] args) {
        Solution207 solution = new Solution207();

        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));
    }
}


class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, i)) {
                return false;
            }
        }

        return true;
    }

    public List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        return graph;
    }

    public boolean dfs(List<List<Integer>> graph, boolean[] visited, int course) {
        if (visited[course]) {
            return true;
        }

        visited[course] = true;

        for (int i = 0; i < graph.get(course).size(); i++) {
            if (dfs(graph, visited, graph.get(course).get(i))) {
                return true;
            }
        }

        visited[course] = false;
        return false;

    }


}


