package org.example.recursion.recursivetree;

import static java.lang.Character.toUpperCase;
import static java.lang.System.out;

public class PermutationCaseChange3 {

    public void solve(String output, String input) {
          /*
        Base Condition
                            O/P I/P
                            ""  "ab"
                            /     \  toUpperCase
                        O/P I/P   O/P I/P
                       "a"  "b"   "A"  "b"
                        /   \        /   \
                  "ab" ""  "aB" "" "Ab" "" "AB" ""
                   Empty String as Input in all leaf Node
        */
        if(input.isEmpty()) {
            out.println(output);
            return;
        }
        /*
                            O/P I/P
                            ""  "ab"
                            /     \  toUpperCase
                        O/P I/P   O/P I/P
                       "a"  "b"   "A"  "b"
         */
        char temp = input.charAt(0);
        String input1 = input.substring(1);
        solve(output + temp, input1);
        solve(output + toUpperCase(temp), input1);
    }

    public static void main(String[] args) {
        PermutationCaseChange3 obj = new PermutationCaseChange3();
        obj.solve("", "ab");
    }
}
