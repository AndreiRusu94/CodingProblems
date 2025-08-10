package third;

public class ListNode {

    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode createListNode(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode node = head;

        for (int value : values) {
            node.next = new ListNode(value);
            node = node.next;
        }

        return head.next;
    }

    public static void displayListNode(ListNode node) {
        if (node == null) {
            return;
        }

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
