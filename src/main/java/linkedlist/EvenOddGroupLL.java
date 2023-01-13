package linkedlist;

public class EvenOddGroupLL {

    Node divide(int N, Node head) {
        Node evenList = new Node(-1);
        Node oddList = new Node(-1);
        Node curr = head, eventemp = evenList, oddTemp = oddList;
        while(curr != null) {
            if(curr.value % 2 == 0) {
                eventemp.next = curr;
                eventemp = eventemp.next;
            }else {
                oddTemp.next = curr;
                oddTemp = oddTemp.next;
            }
            curr = curr.next;
        }
        if(evenList.next != null) {
            eventemp.next = oddList.next;
            return evenList.next;
        }
        return oddList.next;
    }


    public static void main(String[] args) {
        Node node1 = new Node(17);
        Node node2 = new Node(15);
        Node node3 = new Node(8);
        Node node4 = new Node(9);
        Node node5 = new Node(2);
        Node node6 = new Node(4);
        Node node7 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;


        EvenOddGroupLL obj = new EvenOddGroupLL();
        Node res =  obj.divide(7, node1);
        System.out.println(res);


    }
}
