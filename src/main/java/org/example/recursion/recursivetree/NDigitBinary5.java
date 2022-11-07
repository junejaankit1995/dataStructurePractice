package org.example.recursion.recursivetree;

import java.util.ArrayList;


// Only one Condition each combination will be #1s > #0s
public class NDigitBinary5 {

    public void solve(int ones, int zeros, int n, String output) {
         /*
        Base Condition
                            O/P I/P
                                 1s  0s  n
                            ""  "0" "0" "3"  //Each Decision will decrease number of boxes by one
                               |   Only one choice to add 1 for condition prefix will contain #1s > #0s
                            O/P   I/P
                            "1"  "1" "0" "2"
                          1s /     \  0s
                  O/P  I/P          O/P I/P
                 "11"  "2" "0" "1"  "10"  "1" "1" "1"
                    /     \                     |
   "111"  "3" "0" "0"  "110"  "2" "1" "0"     "101"  "2" "1" "0"
          Base Condition  Leaf Node n will be = 0
        */
        if(n == 0) {
            System.out.println(output);
            return;
        }

        solve(ones + 1, zeros, n - 1, output + "1");

        //Choice2
        if(ones > zeros)
            solve(ones, zeros + 1, n - 1, output + "0");
    }

    public static void main(String[] args) {
        NDigitBinary5 obj = new NDigitBinary5();
        obj.solve(0,0 ,4, "");
    }

    //https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1/
    class Solution {
        ArrayList<String> NBitBinary(int n) {
            ArrayList<String> result = new ArrayList<>();
            int ones = 0, zeros = 0;
            solve(ones, zeros, n, "", result);
            return result;
        }

        private void solve(int ones, int zeros, int n, String output, ArrayList<String> cont) {
         /*
        Base Condition
                            O/P I/P
                                 1s  0s  n
                            ""  "0" "0" "3"  //Each Decision will decrease number of boxes by one
                               |   Only one choice to add 1 for condition prefix will contain #1s > #0s
                            O/P   I/P
                            "1"  "1" "0" "2"
                          1s /     \  0s
                  O/P  I/P          O/P I/P
                 "11"  "2" "0" "1"  "10"  "1" "1" "1"
                    /     \                     |
   "111"  "3" "0" "0"  "110"  "2" "1" "0"     "101"  "2" "1" "0"
          Base Condition  Leaf Node n will be = 0
        */
            if(n == 0) {
                cont.add(output);
                return;
            }
            //choice1
            solve(ones + 1, zeros, n - 1, output + "1", cont);

            //Choice2
            if(ones > zeros)
                solve(ones, zeros + 1, n - 1, output + "0", cont);
        }
    }

}
