package Stack;

import java.util.Stack;

//url : https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
public class NextGreaterElemement4 {

    /*Function to find the next greater element for each element of the array.
    *)Identification : value of inner loop depends on upper loop
        arr[j] > arr[i]
    *)We can use a DataStructure know as Stack.

    *)Stack work in LIFO order so to find next Greater Element we have to know about its right element,
    So we have to start from right.
    */
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();
        long[] result = new long[n];
        long max;
        for (int i = n - 1; i > -1; --i) {
            if (stack.empty()) {
                max = -1;
            } else {
                while (!(stack.empty()) && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                max = stack.empty() ? -1 : stack.peek();
            }
            stack.push(arr[i]);
            result[i] = max;
        }
        return result;
    }

    //Brute Force using loop
    public static long[] nextLargerElementUsingLoop(long[] arr, int n) {
        long[] result = new long[n];
        long max;
        for (int i = 0; i < n; i++) {
            max = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    max = arr[j];
                    break;
                }
            }
            result[i] = max;
        }
        return result;
    }
}
