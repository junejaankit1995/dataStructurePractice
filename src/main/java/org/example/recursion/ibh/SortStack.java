package org.example.recursion.ibh;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/sort-a-stack/1
class SortStack {

    public Stack<Integer> sort(Stack<Integer> s) {
        //IBH Method for Recursion
        //Base Condition
        if (s.size() <= 1)
            return s;

        //              I/P                 O/P
        //Hypothesis {1, 0 ,5 , 2 } -> {0, 1, 2, 5}
        //for n-1    {1, 0, 5}     ->  {0, 1, 5}
        Integer temp = s.pop();
        sort(s);

        //Induction  settle |2| popped element is its correct position {1, 0, 5}
        return insert(s, temp);
    }

    private Stack<Integer> insert(Stack<Integer> s, Integer temp) {
        //IBH Method for Recursion
        //Base Condition
        if (s.size() == 0 || s.peek().intValue() <= temp.intValue()) {
            s.push(temp);
            return s;
        }

        //              I/P                 O/P
        //Hypothesis {{0, 1 ,5 }, 2} -> {0, 1, 2, 5}
        //for n-1    {{0, 1}, 2}     ->  {0, 1, 2}
        Integer value = s.pop();
        insert(s, temp);    //{0, 1, 2}


        //Induction {0, 1, 2} push 5
        s.push(value); //{0, 1, 2, 5}
        return s;
    }

}
