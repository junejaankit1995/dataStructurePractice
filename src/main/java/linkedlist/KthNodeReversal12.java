package linkedlist;
//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class KthNodeReversal12 {

    public static Node reverse(Node node, int k) {
        if (k <= 0) {
            return node;
        }
        Node current = node, prevTail = node, temp, prev, newHead = null, newTail = null;
        int nth;
        while (current != null) {
            prev = null;
            nth = k;
            while (current != null && nth > 0) {
                if (prev == null) {
                    newTail = current;
                }
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                --nth;
            }
            if (newHead == null) {
                newHead = prev;
            } else {
                prevTail.next = prev;
                prevTail = newTail;
            }
        }
        return newHead;
    }
}
