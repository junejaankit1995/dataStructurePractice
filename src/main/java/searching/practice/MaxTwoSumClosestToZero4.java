package searching.practice;

import java.util.Arrays;

public class MaxTwoSumClosestToZero4 {

    public static int closestToZero(int arr[], int n) {
        Arrays.sort(arr);
        int start = 0, end = n - 1;
        int minDis = Integer.MAX_VALUE, tempSum;
        while(start < end) {
            tempSum = arr[start] + arr[end];
            if(tempSum == Math.abs(minDis) || Math.abs(tempSum) < Math.abs(minDis)) {
                minDis = tempSum;
            }
            if(tempSum < 0) {
                start++;
            }else {
                --end;
            }
        }
        return minDis;

    }

    public static int bruteForceClosestToZero(int[] arr, int n) {
        int minSum = Integer.MAX_VALUE;
        int tempSum;
        for(int i =0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                tempSum = arr[i] + arr[j];
                if(Math.abs(tempSum) < Math.abs(minSum)) {
                    minSum = tempSum;
                }
            }
        }
        return minSum;
    }
}
