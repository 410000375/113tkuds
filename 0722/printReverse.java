public class printReverse {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void PrintReverse(ListNode head) {
        if (head == null) return;
        PrintReverse(head.next);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        // 建立鏈結串列 1 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        PrintReverse(head); // 輸出: 3 2 1
    }
}