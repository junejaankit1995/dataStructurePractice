package linkedlist;

public class HasCircle3 {

    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    boolean isCircular(Node head) {
        boolean hasCircle = false;
        Node fast = head, slow;
        int nth = 2;
        while(fast != null && nth > 0) {
            --nth;
            fast = fast.next;
        }
        if(nth == 0) {
            slow = head.next;
            while(fast != null && fast.next != null) {
                if(fast == slow) {
                    hasCircle = true;
                    break;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return hasCircle;
    }
}
