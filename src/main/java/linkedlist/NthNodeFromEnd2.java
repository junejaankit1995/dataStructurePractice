package linkedlist;

//https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
public class NthNodeFromEnd2 {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    //Function to find the data of nth node from the end of a linked list.
    int getNthFromLast(Node head, int n)
    {
        Node turtle, mouse = head ;
        int nth = n - 1;
        while(mouse != null && nth > 0) {
            mouse = mouse.next;
            --nth;
        }
        if(nth != 0 || mouse == null)
            return -1;
        turtle = head ;
        while(mouse != null && mouse.next != null) {
            mouse = mouse.next;
            turtle = turtle.next;
        }
        return turtle.data;
    }
}
