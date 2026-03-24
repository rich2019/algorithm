package dewu;

public class ListTest {

    public static void main(String[] args) {
        Node node4 = new Node();
        node4.cur = 4;
        node4.next = null;

        Node node3 = new Node();
        node3.cur = 3;
        node3.next = node4;

        Node node2 = new Node();
        node2.cur = 2;
        node2.next = node3;

        Node node1 = new Node();
        node1.cur = 1;
        node1.next = node2;


        Node node = deleteList(node1, 2);
        while (node.next != null) {
            System.out.println(node.cur);
            node = node.next;
        }
    }

    // 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    // 输入：head = [1,2,3,4,5], n = 2
    // 输出：[1,2,3,5]
    private static Node deleteList(Node list, int num) {
        int count = 1;
        Node tmp = list;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }

        // count 4  num 2
        // 1 2 3 4

        for (int i = 0; i <= count - num; i++) {
            tmp = list.next;
            if (i == count - num) {
                list.next = tmp.next;
                break;
            }
        }

        




        return list;
    }

    static class Node {
        Integer cur;
        Node next;
    }


}
