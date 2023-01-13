package linkedlist;

//https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
public class DivideLL14 {


    Node divide(int N, Node head) {
        Node evenList = new Node(-1);
        Node oddList = new Node(-1);
        Node curr = head, eventemp = evenList, oddTemp = oddList, next;
        while (curr != null) {
            if (curr.value % 2 == 0) {
                eventemp.next = curr;
                eventemp = eventemp.next;
            } else {
                oddTemp.next = curr;
                oddTemp = oddTemp.next;
            }
            next = curr.next;
            curr.next = null;
            curr = next;
        }
        if (evenList.next != null) {
            eventemp.next = oddList.next;
            return evenList.next;
        }
        return oddList.next;
    }
}
