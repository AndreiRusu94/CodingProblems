package third;
/*
Dijkstra on DAG (Topological Order Approach)


*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ProblemDSA64 {
    public static void main(String[] args) {
        SolutionDSA64 solution = new SolutionDSA64();

        int V = 6;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Edge(1, 5));
        adj.get(0).add(new Edge(2, 3));
        adj.get(1).add(new Edge(3, 6));
        adj.get(1).add(new Edge(2, 2));
        adj.get(2).add(new Edge(4, 4));
        adj.get(2).add(new Edge(5, 2));
        adj.get(2).add(new Edge(3, 7));
        adj.get(3).add(new Edge(4, -1));
        adj.get(4).add(new Edge(5, -2));

        int src = 1;
        int[] dist = solution.shortestPathDag(V, adj, src);

        System.out.println("Shortest distances from node " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " = " +
                    (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }
}

class SolutionDSA64 {

    public int[] shortestPathDag(int V, List<List<Edge>> adj, int src) {
        boolean[] visited = new boolean[V];
        Stack<Integer> topo = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, topo, adj);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!topo.isEmpty()) {
            int u = topo.pop();

            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge e : adj.get(u)) {
                    if (dist[e.to] > dist[u] + e.weight) {
                        dist[e.to] = dist[u] + e.weight;
                    }
                }
            }
        }

        return dist;
    }

    private void topologicalSort(int v, boolean[] visited, Stack<Integer> topo, List<List<Edge>> adj) {
        visited[v] = true;

        for (Edge e : adj.get(v)) {
            if (!visited[e.to]) {
                topologicalSort(e.to, visited, topo, adj);
            }
        }

        topo.push(v);
    }

}

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}