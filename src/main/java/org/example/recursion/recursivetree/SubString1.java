package org.example.recursion.recursivetree;


import java.util.ArrayList;
import java.util.List;

public class SubString1 {

    void printSubSet(StringBuilder output, StringBuilder input) {
        /*
        Base Condition
                            O/P I/P
                            ""  "ab"
           does not include /    \include first character
                        O/P I/P   O/P I/P
                       ""  "b"   "a"  "b"
                       /   \        /   \
                   "" ""  "b" ""  "a" "" "ab" ""
                   Empty String as Input in all leaf Node
        */
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        /*
                            O/P I/P
                            ""  "ab"
           does not include /    \include first character
                        O/P1 I/P   O/P2 I/P
                       ""  "b"   "a"  "b"
                  OP1 and O/P2 is same only O/P2 is appended with current character.
         */
        StringBuilder newInput = new StringBuilder(input.substring(1));
        printSubSet(new StringBuilder(output), newInput);
        printSubSet(new StringBuilder(output.append(input.charAt(0))), newInput);
    }

    //Recursive Tree
    void printSubSet(String output, String input) {
        //Base Condition
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        printSubSet(output, input.substring(1));
        printSubSet(output + input.charAt(0), input.substring(1));

    }

    //Variation 2
    public long printAndCount(String input, String output) {
        long count = 0;
        if(input.isEmpty()) {
            System.out.println(output);
            return 1;
        }
        count += printAndCount(input.substring(1), output);
        return count += printAndCount(input.substring(1), output.concat(input.substring(0, 1)));
    }

    //Variation 3 URL : https://leetcode.com/problems/subsets/
    public List<List<Integer>> subsets(int[] intArray) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for(int val : intArray)
            input.add(val);
        getSubSet(input,  new ArrayList<>(), result);
        return result;
    }

    public void getSubSet(List<Integer> input, List<Integer> output, List<List<Integer>> cont) {

        //Base Condition
        if(input.isEmpty()) {
            cont.add(output);
            return;
        }
        List<Integer> newInput = new ArrayList<>(input);
        Integer temp = newInput.remove(0);
        getSubSet(newInput,output, cont);
        List<Integer> newOutput = new ArrayList<>(output);
        newOutput.add(temp);
        getSubSet(newInput, newOutput, cont);
    }



    public static void main(String[] args) {
        SubString1 obj = new SubString1();
        obj.printSubSet(new StringBuilder(), new StringBuilder("ab"));
        obj.printSubSet("", "abc");
        System.out.println(obj.printAndCount("", ""));
        System.out.println(obj.subsets(new int[]{1, 2, 3}));
    }

}
