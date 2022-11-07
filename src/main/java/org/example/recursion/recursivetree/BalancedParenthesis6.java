package org.example.recursion.recursivetree;

public class BalancedParenthesis6 {

    public void printBalancedParenthesis(int n) {
        String output = "";
        int closing = n;
        solve(n, closing, output);
    }

    private void solve(int op, int cl, String out) {
          /*
        Base Condition
                               O/P I/P
                              ""  3 Opening ( | 3 closing )
                               |
                             "("  2 ( | 3 )
                             /          \
                   "(("  1 ( | 3 )       "()"  2 ( | 2 )
                    /        \                        |
        "((("  0 ( | 3 )   "(()"  1 ( | 2 )               "()("  1 ( | 2 )
                |             /        \                      /       \
    "((()" 0( | 2)  "(()(" 0( | 2)  "(())" 1( | 1)  "()((" 0( | 2)     "()()"  1 ( | 1 )
          |               |                  |                  |               |
  "((())" 0( | 1)  "(()()" 0( | 1)    "(())(" 0( | 1) "()(()" 0( | 1)     "()()(" 0( | 1 )
        |               |                  |                  |               |
  "((()))" 0( | 0)  "(()())" 0( | 0)    "(())()" 0( | 0) "()(())" 0( | 0)     "()()()" 0( | 0 )
          0 Value in both inputs
        */
        if (op == 0 && cl == 0) {
            System.out.println(out);
            return;
        }

        //1st Choice
        if (op > 0)
            solve(op - 1, cl, out + "(");

        //2nd Choice
        if (cl > op)
            solve(op, cl - 1, out + ")");
    }

    public static void main(String[] args) {
        BalancedParenthesis6 obj = new BalancedParenthesis6();
        obj.printBalancedParenthesis(3);
    }

}
