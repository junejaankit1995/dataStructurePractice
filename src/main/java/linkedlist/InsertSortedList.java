package linkedlist;

//https://practice.geeksforgeeks.org/problems/insert-in-a-sorted-list/1
public class InsertSortedList {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node sortedInsert(Node head1, int key) {
        Node result = head1;
        Node newNode = new Node(key);
        Node current = head1, previous = null;
        while (current != null && current.data <= key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            newNode.next = head1;
            result = newNode;
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
        }
        return result;
    }
}
