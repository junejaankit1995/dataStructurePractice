package org.example.recursion.recursivetree;


public class SubString1 {

    void basicPrintSubSet(StringBuilder output, StringBuilder input) {
        //Base Condition
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        StringBuilder output1 = new StringBuilder(output);
        StringBuilder output2 = new StringBuilder(output);

        output2.append(input.charAt(0));

        StringBuilder input1 = new StringBuilder(input.substring(1));

        printSubSet(output1, input1);
        printSubSet(output2, input1);
    }

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

    public static void main(String[] args) {
        SubString1 obj = new SubString1();
        //obj.printSubSet(new StringBuilder(""), new StringBuilder("ab"));
        obj.printSubSet("", "abc");
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

}
