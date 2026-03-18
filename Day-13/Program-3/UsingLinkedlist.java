import java.util.*;
// T.C: O(n) 
// S.C: O(n)
class UsingLinkedlist {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    static void printList(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.data);
        if (head.next != null) {
            System.out.print(' ');
        }
        printList(head.next);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) {
                head = node;
                tail = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
        }
        head = reverseList(head);
        printList(head);
    }
}