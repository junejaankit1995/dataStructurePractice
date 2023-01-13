package Stack;

import java.util.Stack;

public class Permutation {

    public static int isStackPermutation(int n, int[] ip, int[] op) {
        Stack<Integer> stack = new Stack<>();
        int index = -1, j = 0;
        for (int i = 0; i < n; ) {
            if (ip[i] == op[j]) {
                j++;
                i++;
            } else {
                index = stack.search(op[j]);
                if (index != -1) {
                    while (index-- > 0) {
                        stack.pop();
                    }
                    j++;
                } else {
                    stack.push(ip[i]);
                    i++;
                }
            }
        }
        while (!stack.empty()) {
            if (stack.pop() == op[j]) {
                j++;
            }
        }
        return j == n ? 1 : 0;
    }

    public static void main(String[] args) {
        Permutation obj = new Permutation();
        System.out.println(obj.isStackPermutation(4, new int[]{1, 2, 3, 4}, new int[]{3, 4, 1, 2}));
    }

}
