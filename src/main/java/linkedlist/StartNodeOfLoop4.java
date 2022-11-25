package linkedlist;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class StartNodeOfLoop4 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {
        ListNode result = null, fast = head, slow;
        int nth = 2;
        while (fast != null && nth > 0) {
            --nth;
            fast = fast.next;
        }
        if (nth == 0) {
            slow = head.next;
            while (fast != null && fast.next != null) {
                if (fast == slow) {
                    result = fast;
                    break;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        if (result != null) {
            slow = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            result = fast;
        }
        return result;
    }
}
