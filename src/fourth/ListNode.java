package fourth;


public class ListNode {
    private int val;
    ListNode next;

    public ListNode(int x) {
        this.setVal(x);
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
            System.out.println(node.getVal());
            node = node.next;
        }
    }

    public static void displayListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.getVal() + " ");
            node = node.next;
        }

        System.out.println();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
