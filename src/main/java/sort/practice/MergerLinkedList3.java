package sort.practice;

public class MergerLinkedList3 {

    static class Node {
        int data;
        Node next;

        Node(int key) {
            this.data = key;
            next = null;
        }
    }


    //////////////////////


    static Node mergeSort(Node head) {
        // add your code here
        if (head.next == null) {
            return head;
        }

        Node middle = middleNode(head);
        Node nHead = middle.next;
        middle.next = null;
        //Hypothesis
        head = mergeSort(head);
        nHead = mergeSort(nHead);

        //Induction (Merging list)
        return merge(head, nHead);
    }

    static Node merge(Node head1, Node head2) {
        Node idx1 = head1;
        Node idx2 = head2;
        Node newHead = new Node(-1);
        Node nTemp = newHead;

        while (idx1 != null && idx2 != null) {
            if (idx1.data <= idx2.data) {
                nTemp.next = idx1;
                idx1 = idx1.next;
            } else {
                nTemp.next = idx2;
                idx2 = idx2.next;
            }
            nTemp = nTemp.next;
        }
        while (idx1 != null) {
            nTemp.next = idx1;
            idx1 = idx1.next;
            nTemp = nTemp.next;
        }
        while (idx2 != null) {
            nTemp.next = idx2;
            idx2 = idx2.next;
            nTemp = nTemp.next;
        }
        return newHead.next;
    }


    //Find first middle element
    static Node middleNode(Node head) {
        Node firstM = null, slow, fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            firstM = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? firstM : slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 4, 1};
        Node nHead = new Node(-1);
        Node temp = nHead;
        Node nNode;
        for (int i = 0; i < arr.length; i++) {
            nNode = new Node(arr[i]);
            temp.next = nNode;
            temp = nNode;
        }

        mergeSort(nHead.next);
    }
}
