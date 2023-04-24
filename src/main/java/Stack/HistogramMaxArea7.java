package Stack;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
public class HistogramMaxArea7 {


    public static long getMaxArea(long hist[], long n) {
        long[] leftSpan = smallestLeftIndex(hist, (int) n);
        long[] rightSpan = smallestRightIndex(hist, (int) n);

        long leftWidth, rightWidth;
        long[] resultSpan = new long[(int) n];
        long maxArea = -1, area;
        for (int i = 0; i < n; i++) {
            leftWidth = i - leftSpan[i];
            rightWidth = rightSpan[i] - i;
            //Counting Span which will be total width subtract 1 because ith index count twice in left and right span.
            resultSpan[i] = leftWidth + rightWidth - 1;
            area = resultSpan[i] * hist[i];
            maxArea = area > maxArea ? area : maxArea;
        }
        return maxArea;
    }

    private static long[] smallestLeftIndex(long[] input, int n) {
        long[] result = new long[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //Stack is empty.
            if (stack.empty()) {
                result[i] = (long) -1;
            } else {
                while (!stack.empty() && input[stack.peek()] >= input[i]) {
                    stack.pop();
                }
                result[i] = stack.empty() ? -1l : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }


    private static long[] smallestRightIndex(long[] input, int n) {
        long[] result = new long[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            //Stack is empty.
            if (stack.empty()) {
                result[i] = n;
            } else {
                while (!stack.empty() && input[stack.peek()] >= input[i]) {
                    stack.pop();
                }
                result[i] = stack.empty() ? (long) n : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}
