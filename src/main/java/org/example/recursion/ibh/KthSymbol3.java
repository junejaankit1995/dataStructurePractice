package org.example.recursion.ibh;

import java.lang.Math;

//https://leetcode.com/problems/k-th-symbol-in-grammar/
public class KthSymbol3 {

    public int kthGrammar(int n, int k) {
        //Base Condition
        if (n == 1 && k == 1)
            return 0;

        /*
        Hypothesis for smaller output for n there will be n-1 row but not every kth value there will be k - 1 value
        table will be                       length
        0                                   1
        0   1                               2
        0   1   1   0                       4
        0   1   1   0   1   0   0   1       8

        2 Observation
            *) length is 2 power of n-1
            *) till mid of length it's exactly same (induction step)
               but after mid its complement (induction step)  of Kth - mid of previous value
        */
        int mid = (int) (Math.pow(2, n - 1)) / 2;
        return k <= mid ? kthGrammar(n - 1, k) : complement(kthGrammar(n - 1, k - mid));
    }

    private int complement(int i) {
        return i == 1 ? 0 : 1;
    }
}
