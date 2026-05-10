package fourth;
/*
Given a node in a connected undirected graph, return a deep copy of the graph.

Each node in the graph contains an integer value and a list of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
The graph is shown in the test cases as an adjacency list. An adjacency list is a mapping of nodes to lists, used to represent a finite graph. Each list describes
the set of neighbors of a node in the graph.

For simplicity, nodes values are numbered from 1 to n, where n is the total number of nodes in the graph. The index of each node within the adjacency list is the
same as the node's value (1-indexed).

The input node will always be the first node in the graph and have 1 as the value.

Example 1:

Input: adjList = [[2],[1,3],[2]]

Output: [[2],[1,3],[2]]
Explanation: There are 3 nodes in the graph.
Node 1: val = 1 and neighbors = [2].
Node 2: val = 2 and neighbors = [1, 3].
Node 3: val = 3 and neighbors = [2].

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class ProblemNC35 {
    public static void main(String[] args) {
        SolutionNC35.Node graph = SolutionNC35.buildGraph();
        SolutionNC35.Node cloned = SolutionNC35.cloneGraph(graph);
        boolean areEqual = SolutionNC35.compareGraphs(graph, cloned, new HashMap<>());

        System.out.println("Graphs are equal: " + areEqual);
    }
}

class SolutionNC35 {

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
        if (node == null) {
            return null;
        }

        Deque<Node> dq = new ArrayDeque<>();
        Map<Node, Node> oldToNew = new HashMap<>();

        oldToNew.put(node, new Node(node.val));
        dq.add(node);

        while (!dq.isEmpty()) {
            Node curr = dq.poll();
            for (Node neighbor : curr.neighbors) {
                if (!oldToNew.containsKey(neighbor)) {
                    dq.offer(neighbor);
                    oldToNew.put(neighbor, new Node(neighbor.val));
                }

                oldToNew.get(curr).neighbors.add(oldToNew.get(neighbor));
            }
        }

        return oldToNew.get(node);
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

