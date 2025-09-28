package third;
/*
Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes and m edges, with each node having a distinct label
from 0 to n-1, and each adj[i] represents the list of vertices connected to vertex i.

Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are
adjacent to the current node.

class Node {
    val: integer
    neighbors: List[Node]
}

Your task is to clone the given graph and return a reference to the cloned graph.

Note: If you return a correct copy of the given graph, the output will be true; otherwise, if the copy is incorrect, it will print false.

Examples

Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
Output: true

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class ProblemDSA70 {
    public static void main(String[] args) {
        SolutionDSA70.Node graph = SolutionDSA70.buildGraph();
        SolutionDSA70.Node cloned = SolutionDSA70.cloneGraph(graph);
        boolean areEqual = SolutionDSA70.compareGraphs(graph, cloned, new HashMap<>());

        System.out.println("Graphs are equal: " + areEqual);
    }
}

class SolutionDSA70 {

    static class Node {
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node() {
            this.neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        Node clone = new Node(node.val);
        visited.put(node, clone);

        Deque<Node> dq = new ArrayDeque<>();
        dq.add(node);

        while (!dq.isEmpty()) {
            Node current = dq.poll();

            for (Node neighbour : current.neighbors) {
                if (!visited.containsKey(neighbour)) {
                    visited.put(neighbour, new Node(neighbour.val));
                    dq.add(neighbour);
                }

                visited.get(current).neighbors.add(visited.get(neighbour));
            }
        }

        return visited.get(node);
    }

    public static Node buildGraph() {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);

        node1.neighbors.addAll(new ArrayList<>
                (asList(node2, node3)));
        node2.neighbors.addAll(new ArrayList<>
                (asList(node1, node3)));
        node3.neighbors.addAll(new ArrayList<>
                (asList(node1, node2, node4)));
        node4.neighbors.addAll(new ArrayList<>
                (List.of(node3)));

        return node1;
    }

    public static boolean compareGraphs(Node first, Node second, Map<Node, Node> visited) {
        if (first == null || second == null) {
            return first == second;
        }

        if (first.val != second.val || first == second) {
            return false;
        }

        visited.put(first, second);

        for (int i = 0; i < first.neighbors.size(); i++) {
            Node n1 = first.neighbors.get(i);
            Node n2 = second.neighbors.get(i);

            if (visited.containsKey(n1)) {
                if (visited.get(n1) != n2) {
                    return false;
                }
            } else if (!compareGraphs(n1, n2, visited)) {
                return false;
            }
        }

        return true;
    }

}

