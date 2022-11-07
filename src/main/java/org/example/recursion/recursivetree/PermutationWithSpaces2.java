package org.example.recursion.recursivetree;

import java.util.ArrayList;

import static java.lang.System.out;

public class PermutationWithSpaces2 {


    public void solve(String output, String input) {
         /*
        Base Condition
                            O/P I/P
                            "A"  "BC"
         include with space /    \include without space character
                        O/P I/P   O/P I/P
                       "A_B"  "C"   "AB"  "C"
                       /   \        /   \
            "A_B_C" ""  "A_BC" "" "AB_C" "" "" "ABC" ""
                   Empty String as Input in all leaf Node
        */
        if (input.isEmpty()) {
            out.println(output);
            return;
        }

          /*
        Base Condition
                            O/P I/P
                            "A"  "BC"
         include with space /    \include without space character
                        O/P I/P   O/P I/P
                       "A_B"  "C"   "AB"  "C"
        */
        String input1 = input.substring(1);
        char add = input.charAt(0);
        solve(output + " " + add, input1);
        solve(output + add, input1);


    }


    public static void main(String[] args) {
        String input = "ABC";
        PermutationWithSpaces2 obj = new PermutationWithSpaces2();
        /*
        Intialization
        "" "ABC"
            |  We have only one choice
          O/P I/P
        "A"  "BC"
        */
        obj.solve(""+input.charAt(0), input.substring(1));
        //obj.permutation("ABC");
    }


    class Solution{
        //https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1

        ArrayList<String> permutation(String S){
         /*
        Intialization
        "" "ABC"
            |  We have only one choice
          O/P I/P
        "A"  "BC"
        */
            ArrayList<String> result = new ArrayList<>();
            solve("" + S.charAt(0), S.substring(1), result);
            return result;
        }

        public void solve(String output, String input, ArrayList<String> cont) {
          /*
        Base Condition
                            O/P I/P
                            "A"  "BC"
         include with space /    \include without space character
                        O/P I/P   O/P I/P
                       "A_B"  "C"   "AB"  "C"
                       /   \        /   \
            "A_B_C" ""  "A_BC" "" "AB_C" "" "" "ABC" ""
                   Empty String as Input in all leaf Node
        */
            if(input.isEmpty()) {
                cont.add(output);
                return;
            }


          /*
        Base Condition
                            O/P I/P
                            "A"  "BC"
         include with space /    \include without space character
                        O/P I/P   O/P I/P
                       "A_B"  "C"   "AB"  "C"
        */
            String input1 = input.substring(1);
            char add = input.charAt(0);
            solve(output + " " + add, input1, cont);
            solve(output + add, input1, cont);
        }

    }




}
