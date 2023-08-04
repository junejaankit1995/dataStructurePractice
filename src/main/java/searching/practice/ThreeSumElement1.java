package searching.practice;

import java.util.*;

public class ThreeSumElement1 {

    public static boolean find3Numbers(int arr[], int n, int X) {
        boolean result = false;
        int j, k, tempSum;
        Arrays.sort(arr);
        for (int i = 0; i < (n - 2); i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                tempSum = arr[i] + arr[j] + arr[k];
                if (tempSum < X) {
                    j++;
                } else if (tempSum > X) {
                    k--;
                } else {
                    return true;
                }
            }
        }
        return result;
    }


    public static boolean find3Numbers1(int arr[], int n, int X) {
        HashSet<Integer> set = new HashSet<>();
        int temp;
        boolean result = false;
        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            for (int j = 0 + 1; j < n; j++) {
                temp = arr[i] + arr[j];
                if (set.contains(X - temp)) {
                    result = true;
                    break;
                }
                set.add(arr[j]);
            }
            if (result == true) {
                break;
            }
        }
        return result;
    }

    public static List<List<Integer>> find3Numbers(int arr[], int n) {
        // Write your code here.
        List<Integer> valueList;
        List<Integer> sumList;
        HashSet<List<Integer>> uniqueValue = new HashSet<>();
        int lValue;
        for (int i = 0; i < n; i++) {
            valueList = new ArrayList<>();
            for (int j = i + 1; j < n; j++) {
                lValue = -(arr[i] + arr[j]);
                if (valueList.contains(lValue)) {
                    sumList = new ArrayList<>();
                    sumList.add(arr[i]);
                    sumList.add(arr[j]);
                    sumList.add(lValue);
                    Collections.sort(sumList);
                    uniqueValue.add(sumList);
                }
                valueList.add(arr[j]);
            }
        }
        return new ArrayList<>(uniqueValue);

    }

    public static void main(String[] args) {
        int[] input = new int[]{-18, -1, -44, -48, -9, -16, -36, -13, 29, 17, -12, 9, -49};
        System.out.println(find3Numbers(input, input.length));
    }
}
