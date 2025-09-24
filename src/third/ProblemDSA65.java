package third;
/*
Given an undirected connected graph of n vertices and a list of m edges in a graph and for each pair of vertices that are connected by an edge.
There are two edges between them, one curved edge and one straight edge i.e. the tuple (x, y, w1, w2) means that between vertices x and y, there
 is a straight edge with weight w1 and a curved edge with weight w2. You are given two vertices a and b and you have to go from a to b through
 a series of edges such that in the entire path you can use at most 1 curved edge. Your task is to find the shortest path from a to b satisfying
 the above condition. If there is no path from a to b, return -1.

Examples:

Input: n = 4, m = 4, a = 2, b = 4, edges = {{1, 2, 1, 4}, {1, 3, 2, 4}, {1, 4, 3, 1}, {2, 4, 6, 5}}
Output: 2
Explanation: We can follow the path 2->1->4. This gives a distance of 1+3 = 4 if we follow all straight paths. But we can take the curved path
 from 1 -> 4, which costs 1. This will result in a cost of 1+1 = 2



Input: n = 2, m = 1, a = 1, b = 2, edges = {{1, 2, 4, 1}}
Output : 1
Explanation: Take the curved path from 1 to 2 which costs 1.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemDSA65 {
    public static void main(String[] args) {
        SolutionDSA65 solution = new SolutionDSA65();

        int n = 4;
        int[][] edges = {
                {1, 2, 1, 4},
                {1, 3, 2, 4},
                {1, 4, 3, 1},
                {2, 4, 6, 5}
        };
        int src = 2, dest = 4;

        System.out.println(solution.shortestPath(n, edges, src, dest));
    }
}

class SolutionDSA65 {

    public int shortestPath(int n, int[][] edges, int src, int dest) {
        int[] distSrc = dijkstra(edges, n, src);
        int[] distDest = dijkstra(edges, n, dest);

        int output = distSrc[dest];

        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];
            int w2 = edge[3];

            if (distSrc[v] != Integer.MAX_VALUE && distDest[u] != Integer.MAX_VALUE) {
                output = Math.min(output, distSrc[v] + w2 + distDest[u]);
            }

            if (distSrc[u] != Integer.MAX_VALUE && distDest[v] != Integer.MAX_VALUE) {
                output = Math.min(output, distSrc[u] + w2 + distDest[v]);
            }
        }

        return output;
    }

    private int[] dijkstra(int[][] edges, int v, int src) {
        List<List<List<Integer>>> adj = constructAdj(edges, v);
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        List<Integer> start = new ArrayList<>();
        start.add(0);
        start.add(src);

        pq.add(start);

        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!pq.isEmpty()) {
            List<Integer> curr = pq.poll();
            Integer u = curr.get(1);

            for (List<Integer> neighbour : adj.get(u)) {
                Integer i = neighbour.get(0);
                Integer weight = neighbour.get(1);
                if (dist[i] > dist[u] + weight) {
                    dist[i] = dist[u] + weight;
                    pq.add(List.of(dist[i], i));
                }
            }
        }

        return dist;
    }

    private List<List<List<Integer>>> constructAdj(int[][] edges, int n) {
        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];
            int w1 = edge[2];

            adj.get(v).add(List.of(u, w1));
            adj.get(u).add(List.of(v, w1));
        }

        return adj;
    }

}