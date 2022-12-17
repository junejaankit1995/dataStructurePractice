package linkedlist;

//https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
public class MergeSortedLL10 {

    Node sortedMerge(Node head1, Node head2) {
        Node result = new Node(-1);
        Node list1 = head1, list2 = head2, temp = result;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return result.next;
    }

}
