package searching.practice;

import java.util.*;

public class ThreeSumtoZero5 {

    public static List<List<Integer>> triplet(int n, int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tripletList;
        Arrays.sort(arr);
        int i = 0, j, k, tempSum;
        while (i < n - 2) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            j = i + 1;
            k = n - 1;
            while (j < k) {
                tempSum = arr[i] + arr[j] + arr[k];
                if (tempSum < 0) {
                    while (j < k && arr[j] == arr[j + 1]) {
                        j++;
                    }
                    j++;
                } else if (tempSum > 0) {
                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                    }
                    k--;
                } else {
                    tripletList = new ArrayList<>();
                    tripletList.add(arr[i]);
                    tripletList.add(arr[j]);
                    tripletList.add(arr[k]);
                    result.add(tripletList);
                    while (j < k && arr[j] == arr[j + 1]) {
                        j++;
                    }
                    j++;
                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                    }
                    k--;
                }
            }
            i++;
        }
        return result;
    }


    public static List<List<Integer>> tripletUsingExtraSpace(int n, int[] arr) {
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
}
