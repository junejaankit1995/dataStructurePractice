package Stack;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/max-rectangle/1
public class MaxRectBinaryMatrix8 {


    public int maxArea(int M[][], int n, int m) {
        int intAr;
        int maxAr = getMaxArea(M[0], m);
        int[] inter = M[0];
        //Row
        for (int i = 1; i < n; i++) {
            //Col
            for (int j = 0; j < m; j++) {
                inter[j] = M[i][j] != 0 ? inter[j] + M[i][j] : 0;
            }
            //Area of ith Array
            intAr = getMaxArea(inter, m);
            maxAr = intAr > maxAr ? intAr : maxAr;
        }
        return maxAr;
    }


    public int getMaxArea(int hist[], int n) {
        int[] leftSpan = smallestLeftIndex(hist, n);
        int[] rightSpan = smallestRightIndex(hist, n);

        int leftWidth, rightWidth;
        int[] resultSpan = new int[n];
        int maxArea = -1, area;
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

    private int[] smallestLeftIndex(int[] input, int n) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //Stack is empty.
            if (stack.empty()) {
                result[i] = -1;
            } else {
                while (!stack.empty() && input[stack.peek()] >= input[i]) {
                    stack.pop();
                }
                result[i] = stack.empty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }


    private int[] smallestRightIndex(int[] input, int n) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            //Stack is empty.
            if (stack.empty()) {
                result[i] = n;
            } else {
                while (!stack.empty() && input[stack.peek()] >= input[i]) {
                    stack.pop();
                }
                result[i] = stack.empty() ? n : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
}
