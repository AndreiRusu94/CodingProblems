package second;


public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    public static ListNode createListNode(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode current = new ListNode(values[0]);
        ListNode head = current;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return head.next;
    }

    public static void outputListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
