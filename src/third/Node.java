package third;

import static third.TreeNode.BFS;
import static third.TreeNode.inOrderDFS;
import static third.TreeNode.postOrderDFS;
import static third.TreeNode.preOrderDFS;

public class Node {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);


        System.out.print("In-order DFS: ");
        inOrderDFS(root);
        System.out.print("\nPre-order DFS: ");
        preOrderDFS(root);
        System.out.print("\nPost-order DFS: ");
        postOrderDFS(root);
        System.out.print("\nLevel order: ");
        BFS(root);
    }
}
