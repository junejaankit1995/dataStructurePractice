package linkedlist;

//https://practice.geeksforgeeks.org/problems/find-length-of-loop/1
public class LenghtOfLoop5 {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head) {
        Node fast = head, slow;
        boolean loopExist = false;
        int nth = 2, result = 0;
        while (fast != null && nth > 0) {
            --nth;
            fast = fast.next;
        }
        if (nth == 0) {
            slow = head.next;
            while (fast != null && fast.next != null) {
                if (fast == slow) {
                    loopExist = true;
                    break;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            if (loopExist) {
                fast = fast.next;
                ++result;
                while (fast != slow) {
                    fast = fast.next;
                    ++result;
                }
            }
        }
        return result;
    }
}
