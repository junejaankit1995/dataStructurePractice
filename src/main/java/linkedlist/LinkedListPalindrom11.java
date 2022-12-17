package linkedlist;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class LinkedListPalindrom11 {

    boolean isPalindrome(Node head) {
        boolean result = true;
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.value != stack.pop().value) {
                result = false;
                break;
            }
            temp = temp.next;
        }
        return result;
    }
}
