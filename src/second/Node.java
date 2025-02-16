package second;


import java.util.ArrayList;
import java.util.List;

public class Node {
    int val;
    Node next;
    Node random;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.neighbors = new ArrayList<>();
    }

    public static Node createListNode(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node current = new Node(values[0]);
        Node head = current;

        for (int value : values) {
            current.next = new Node(value);
            current = current.next;
        }

        return head.next;
    }

    public static void outputListNode(Node node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void displayListNode(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }
}
