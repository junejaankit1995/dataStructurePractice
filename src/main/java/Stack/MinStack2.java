package Stack;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1
public class MinStack2 {
    int minEle;
    Stack<Integer> s = new Stack<>();
    Stack<Integer> m = new Stack<>();

    /*returns min element from stack*/
    int getMin() {
        return m.empty() ? -1 : m.peek();
    }

    /*returns poped element from stack*/
    int pop() {
        int result = -1;
        if (!s.empty()) {
            result = s.pop();
            if (result == m.peek()) {
                m.pop();
            }
        }
        return result;
    }

    /*push element x into the stack*/
    void push(int x) {
        s.push(x);
        if (m.empty() || m.peek() >= x) {
            m.push(x);
        }
    }
}
