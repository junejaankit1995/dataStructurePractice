package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//URL : https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1
public class SmallestNumberLeft5 {

    /*
    Function to find the next smallest left element for each element of the array.
    *)Identification : value of inner loop depends on upper loop
        arr[j] < arr[i]
    *)We can use a DataStructure know as Stack.

    *)Stack work in LIFO order so to find previous Smallest Element we have to know about its left element,
    So we have to start from left.
    */
    static List<Integer> leftSmaller(int n, int a[]) {
        List<Integer> resCont = new ArrayList<>();
        int min = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                min = -1;
            } else {
                while (!(stack.empty()) && stack.peek() >= a[i]) {
                    stack.pop();
                }
                min = stack.empty() ? -1 : stack.peek();
            }
            stack.push(a[i]);
            resCont.add(min);
        }
        return resCont;
    }
    //Brute Force using Loop
    static List<Integer> leftSmallerBruteForce(int n, int a[]) {
        List<Integer> resCont = new ArrayList<>();
        int min;
        for (int i = 0; i < n; i++) {
            min = -1;
            for (int j = i - 1; j > -1; j--) {
                if (a[j] < a[i]) {
                    min = a[j];
                    break;
                }
            }
            resCont.add(min);
        }
        return resCont;
    }
}
