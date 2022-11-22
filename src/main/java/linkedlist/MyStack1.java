package linkedlist;

//https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
class MyStack1
{
    class StackNode {
         int data;
         StackNode next;
         StackNode(int a) {
             data = a;
             next = null;
         }
     }
    StackNode top;

    //Function to push an integer into the stack.
    void push(int a)
    {
        if(top == null) {
            top = new StackNode(a);
        } else {
            StackNode temp = new StackNode(a);
            temp.next = top;
            top = temp;
        }
    }

    //Function to remove an item from top of the stack.
    int pop()
    {
        if(top == null) {
            return -1;
        } else {
            StackNode temp = top;
            top = top.next;
            return temp.data;
        }

    }
}
