package Stack;

import java.util.Stack;

public class Permutation1 {

    public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(ip[i]);
            if (!stack.empty() && stack.peek() == op[j]) {
                while (!stack.empty() && stack.peek() == op[j]) {
                    stack.pop();
                    j++;
                }
            }
        }
        return stack.empty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Permutation1 obj = new Permutation1();
        System.out.println(obj.isStackPermutation(4, new int[]{1, 2, 3, 4}, new int[]{3, 4, 1, 2}));
    }

}
