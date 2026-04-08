package test;

public class Test {

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        int count = 1;
        Node countNode = head;
        while (countNode.next != null) {
            countNode = countNode.next;
            count++;
        }


        int move = 0;
        Node start = head;
        while (move < count / 2) {
            moveLastToSecond(start);
            start = start.next;
            move++;
        }

        // 输出
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    private static void moveLastToSecond(Node head) {
        Node tmpNode = head;
        while (tmpNode.next != null) {
            Node nextNode = tmpNode.next;

            if (nextNode.next == null) {
                nextNode.next = head.next;
                head.next = nextNode;
                nextNode.next = null;
            }
            tmpNode = nextNode;
        }
    }
}
