package third;

import static third.TreeNode.BFS;
import static third.TreeNode.deleteNode;
import static third.TreeNode.inOrderDFS;
import static third.TreeNode.insertLevelOrder;
import static third.TreeNode.insertNode;
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

        System.out.print("\nInsert level order (complete binary tree): ");
        TreeNode tree = insertLevelOrder(new int[]{1, 2, 3, 4, 5, 6}, 0);
        inOrderDFS(tree);

        System.out.print("\nInsert node: ");
        root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        int key = 12;
        root = insertNode(root, key);
        inOrderDFS(root);

        System.out.print("\nDelete node: ");
        root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        key = 11;
        root = deleteNode(root, key);
        inOrderDFS(root);
    }
}
