package linkedlist;

import java.util.Set;
import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/intersection-of-two-linked-list/1
public class IntersectionLinkedList8 {
    static class Node {
        int data;
        Node next;

        Node(int a) {
            data = a;
            next = null;
        }
    }


    public static Node findIntersection(Node head1, Node head2) {
        Set<Integer> set = new HashSet<>();
        Node list1 = head1, list2 = head2, temp;
        Node result = new Node(-1);
        temp = result;
        while (list2 != null) {
            set.add(list2.data);
            list2 = list2.next;
        }
        while (list1 != null) {
            if (set.contains(list1.data)) {
                temp.next = new Node(list1.data);
                temp = temp.next;
            }
            list1 = list1.next;
        }
        return result.next;

    }

}
