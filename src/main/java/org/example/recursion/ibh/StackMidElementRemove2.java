package org.example.recursion.ibh;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1/
public class StackMidElementRemove2 {

    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        //Edge Condition
        if (s.size() == 0)
            return;
        int mid = s.size() / 2;
        solve(s, mid + 1);
    }

    private void solve(Stack<Integer> s, int k) {
        //BaseCondition Smallest valid Input (kth value)
        if (k == 1) {
            s.pop();
            return;
        }

        //              I/P                 O/P
        //Hypothesis ({1, 2 ,3 , 4, 5}, 3) -> {1, 2, 4, 5}
        //for k-1    ({1, 2, 3, 4}, 2)     ->  {1, 2, 4}
        Integer temp = s.pop();
        solve(s, k - 1);

        //Induction add last element {1, 2, 4, 5}
        s.push(temp);
    }
}
