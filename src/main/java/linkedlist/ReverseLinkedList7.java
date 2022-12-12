package linkedlist;

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }

    //Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[" + value + "],");
        Node temp = next;
        while(temp != null) {
            builder.append(new StringBuilder("[" + temp.value + "],"));
            temp = temp.next;
        }
        return builder.toString();
    }
}

public class ReverseLinkedList7 {

    Node reverseList1(Node list) {
        //Base Condition
        if(list.next == null) {
            return list;
        }

        //Hypothesis(Smaller Input)
        Node currentHead = list;
        list = list.next;
        currentHead.next = null;
              //Induction(insert)
        return insert(reverseList(list), currentHead);
    }

    private Node insert(Node list, Node value) {
        //Base Condition
        if(list.next == null) {
            list.next = value;
            return list;
        }

        Node temp = list;
        list = list.next;
        temp.next = null;

       Node result = insert(list, value);
       temp.next = result;
       result= temp;
       return result;
    }


    Node reverseList2(Node list) {
        Node current = list, next, previous = null;
        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    Node reverseList(Node head) {
        //Base Condition
        if(head == null || head.next == null)
            return head;
        /*Hypothesis (Smaller Input)
            Input
            1 -> 2 -> 3 -> 4 -> 5 -> 6;
            Smaller Input
            2 -> 3 -> 4 -> 5 -> 6
         */
        Node newHead = reverseList(head.next);
        /*Induction
            Beauty of Hypothesis
            Consider whole n-1 list is reverse only head node is not
             head         newHead
             1 -> 2       6 -> 5 -> 4 -> 3 -> 2 -> 1;
             Step one
             Set head.next Node next to itself
             1 -> 2.next = head (1);

             Step 2
             Set head.next = null to remove cycle;
             head.next = null
             return newHead of Hypothesis
                                */
        head.next.next = head;
        head.next = null;
        return newHead;
    }



    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ReverseLinkedList7 obj = new ReverseLinkedList7();
        System.out.println(obj.reverseList(node1));

    }

}
