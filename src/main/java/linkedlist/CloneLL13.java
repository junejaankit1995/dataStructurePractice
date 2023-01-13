package linkedlist;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
public class CloneLL13 {
    Node1 copyList(Node1 head) {
        HashMap<String, Node1> map = new HashMap<>();
        Node1 result = new Node1(-1);
        Node1 copyTemp = result, temp = head, newNode;
        while (temp != null) {
            newNode = new Node1(temp.data);
            copyTemp.next = newNode;
            copyTemp = copyTemp.next;
            map.put(temp.toString(), newNode);
            temp = temp.next;
        }
        temp = head;
        copyTemp = result.next;
        while (temp != null) {
            if (temp.arb != null) {
                copyTemp.arb = map.get(temp.arb.toString());
            }
            copyTemp = copyTemp.next;
            temp = temp.next;
        }
        return result.next;
    }
}

class Node1 {
    int data;
    Node1 next, arb;

    Node1(int d) {
        data = d;
        next = arb = null;

    }
}
