package Stack;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
public class StackSpan6 {
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int[] price, int n) {
        int[] greIndex = leftGreatestIndex(price, n);
        int[] span = new int[n];
        for (int i = 0; i < n; i++) {
            span[i] = i - greIndex[i];
        }
        return span;
    }

    private static int[] leftGreatestIndex(int[] input, int n) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //Stack is empty()
            if (stack.empty()) {
                result[i] = -1;
            } else {
                //Stack contain index of element
                while (!stack.empty() && input[stack.peek()] <= input[i]) {
                    stack.pop();
                }
                //If Stack contain element means there is greater element persent.
                result[i] = stack.empty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}
