package third;
/*
Hierholzer's Algorithm for directed graph.
Given a directed Eulerian graph, the task is to print an Euler circuit. An Euler circuit is a path that traverses every edge of a graph exactly
once, and the path ends on the starting vertex.

Note: The given graph contains a Euler circuit.

Prerequisites:

We have discussed the problem of finding out whether a given graph is Eulerian or not for an Undirected Graph
Conditions for Eulerian circuit in a Directed Grpag : (1) All vertices belong to a single strongly connected component. (2) All vertices have same
 in-degree and out-degree. Note that for an undirected graph, the condition is different (all vertices have even degree)
Approach:

Choose any starting vertex v, and follow a trail of edges from that vertex until returning to v. It is not possible to get stuck at any vertex
other than v, because indegree and outdegree of every vertex must be same, when the trail enters another vertex w there must be an unused edge
leaving w. The tour formed in this way is a closed tour, but may not cover all the vertices and edges of the initial graph.
As long as there exists a vertex u that belongs to the current tour, but that has adjacent edges not part of the tour, start another trail from u,
following unused edges until returning to u, and join the tour formed in this way to the previous tour.

Example:
Input : Directed graph
Output: 0 3 4 0 2 1 0

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class ProblemDSA73 {
    public static void main(String[] args) {
        SolutionDSA73 solution = new SolutionDSA73();

        int[][] edges = {{2, 3}, {0}, {1}, {4}, {0}};
        int v = 5;

        System.out.println(solution.findCircuit(edges, v));
    }
}

class SolutionDSA73 {

    public List<Integer> findCircuit(int[][] edges, int v) {
        List<List<Integer>> adj = constructAdj(edges, v);

        List<Integer> circuit = new ArrayList<>();
        Deque<Integer> currPath = new ArrayDeque<>();
        currPath.add(0);

        while (!currPath.isEmpty()) {
            int currNode = currPath.peek();

            if (!adj.get(currNode).isEmpty()) {
                int next = adj.get(currNode).remove(adj.get(currNode).size() - 1);
                currPath.push(next);
            } else {
                circuit.add(currPath.pop());
            }
        }

        Collections.reverse(circuit);
        return circuit;
    }

    private List<List<Integer>> constructAdj(int[][] edges, int v) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                adj.get(i).add(edges[i][j]);
            }
        }

        return adj;
    }

}

