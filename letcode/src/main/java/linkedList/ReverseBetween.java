package linkedList;

public class ReverseBetween {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode reversed = reverseBetween(head, 3, 4);
        System.out.println(reversed);
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode begin = head;
        ListNode pre = null;
        for (int i = 0; i < left - 1; i++) {
            if (i == left - 2) {
                pre = head;
            }
            head = head.next;
        }

        // 0 1 2 3 4
        for (int i = 0; i < right - left; i++) {
            ListNode next = head.next;
            head.next = pre;
            next.next = head;
            pre = head;
            head = next;
        }

        return begin;
    }


}
