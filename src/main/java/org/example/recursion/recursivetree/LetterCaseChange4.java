package org.example.recursion.recursivetree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-case-permutation/submissions/
public class LetterCaseChange4 {

    public List<String> letterCasePermutation(String s) {
        String output = "";
        List<String> cont =  new ArrayList<>();
        solve(output, s, cont);
        return cont;
    }

    public void solve(String output, String input, List<String> cont) {
        /*
        Base Condition
                            O/P I/P
                            ""  "a1b1"
                toLowerCase /     \  toUpperCase
                        O/P I/P   O/P I/P
                       "a"  "1b1"   "A"  "1b1"
                           |            |
                      "a1" "b1"      "A1" "b1"
                        /   \        /   \
                "a1b" "1"  "a1B" "1" "A1b" "1" "A1B" "1"
                     /         \     /           \
            "a2b1" ""    "a1B1" ""  "A1b1" ""   "A1B1"
                   Empty String as Input in all leaf Node
        */
        if(input.isEmpty()) {
            cont.add(output);
            return;
        }
        char temp = input.charAt(0);
        String input1 = input.substring(1);
        if(Character.isLetter(temp)) {
            /*
                            O/P I/P
                            ""  "a1b1"
                toLowerCase /     \  toUpperCase
                        O/P I/P   O/P I/P
                    "a"  "1b1"   "A"  "1b1"
            */
            solve(output + Character.toLowerCase(temp) , input1, cont);
            solve(output + Character.toUpperCase(temp), input1, cont);
        } else {
            solve(output + temp, input1, cont);
        }
    }

}
