package third;
/*
Huffman coding:

There are mainly two major parts in Huffman Coding
Build a Huffman Tree from input characters.
Traverse the Huffman Tree and assign codes to characters.

Input:
String s = "abcdef";
int[] freq = {5, 9, 12, 13, 16, 45};

Output: 0 100 101 1100 1101 111
*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ProblemDSA79 {
    public static void main(String[] args) {
        SolutionDSA79 solution = new SolutionDSA79();

        String s = "abcdef";
        int[] freq = {5, 9, 12, 13, 16, 45};

        System.out.println(solution.huffmanCodes(freq, s));
    }
}

class SolutionDSA79 {

    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
        }
    }

    public List<String> huffmanCodes(int[] freq, String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.data < b.data ) return -1;
            return 1;
        });

        for (int i : freq) {
            pq.add(new Node(i));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node internal = new Node(left.data + right.data);
            internal.left = left;
            internal.right = right;

            pq.add(internal);
        }

        Node root = pq.poll();
        List<String> output = new ArrayList<>();
        preorder(root, output, "");
        return output;
    }

    private void preorder(Node root, List<String> output, String curr) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            output.add(curr);
            return;
        }

        preorder(root.left, output, curr + "0");
        preorder(root.right, output, curr + "1");
    }

}

