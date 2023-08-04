package sort.practice;

import sort.practice.helper.Node;
import sort.practice.helper.QuickSortPartitionResultNode;

public class QuickSort4 {


    public Node quickSort(Node head) {
        //Terminal Condition
        if (head == null || head.next == null) {
            return head;
        }

        QuickSortPartitionResultNode pNode = partition(head);
        Node lHead = quickSort(pNode.lHead);
        Node rHead = quickSort(pNode.rHead);

        return join(lHead, pNode.pivot, rHead);
    }

    private QuickSortPartitionResultNode partition(Node head) {
        Node pivot = head, temp = pivot.next;
        pivot.next = null;
        Node lHead = new Node(-1);
        Node rHead = new Node(-1);
        Node lTemp = lHead, rTemp = rHead;

        while (temp != null) {
            if (temp.data <= pivot.data) {
                lTemp.next = new Node(temp.data);
                lTemp = lTemp.next;
            } else {
                rTemp.next = new Node(temp.data);
                rTemp = rTemp.next;
            }
            temp = temp.next;
        }

        return new QuickSortPartitionResultNode(lHead.next, pivot, rHead.next);
    }

    public Node join(Node lHead, Node pivot, Node rHead) {
        Node newHead = new Node(-1);
        Node temp = lHead, nTemp = newHead;
        while (temp != null) {
            nTemp.next = temp;
            temp = temp.next;
            nTemp = nTemp.next;
        }
        nTemp.next = pivot;
        nTemp = pivot;
        temp = rHead;
        while (temp != null) {
            nTemp.next = temp;
            temp = temp.next;
            nTemp = nTemp.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{70, 99, 4, 88, 71, 8, 12, 70, 27};
        Node nHead = new Node(-1);
        Node temp = nHead;
        Node nNode;
        for (int i = 0; i < arr.length; i++) {
            nNode = new Node(arr[i]);
            temp.next = nNode;
            temp = nNode;
        }

        QuickSort4 obj = new QuickSort4();
        System.out.println(obj.quickSort(nHead.next));
    }
}
