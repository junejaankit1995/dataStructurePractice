package Stack;

//url : https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
public class TwoStack3 {
    //Function to push an integer into the stack1.
    void push1(int x, TwoStack sq) {
        sq.arr[++sq.top1] = x;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq) {
        sq.arr[--sq.top2] = x;

    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq) {
        return sq.top1 == -1 ? sq.top1 : sq.arr[sq.top1--];
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq) {
        return sq.top2 == 100 ? -1 : sq.arr[sq.top2++];
    }

    class TwoStack {

        int size;
        int top1, top2;
        int arr[] = new int[100];

        TwoStack() {
            size = 100;
            top1 = -1;
            top2 = size;
        }
    }
}
