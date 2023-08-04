package searching.practice;

import java.util.HashSet;

public class TripletKSum3 {

    //Function to find if there exists a triplet in the
    //array A[] which sums up to X.

    public static boolean find3Numbers(int arr[], int n, int X) {
        int kValue;
        HashSet<Integer> set;
        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                kValue = X - (arr[i] + arr[j]);
                if (set.contains(kValue)) {
                    return true;
                }
                set.add(arr[j]);
            }
        }
        return false;
    }

    public static boolean bruteForceFind3Numbers(int arr[], int n, int X) {
        int tempSum;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    tempSum = arr[i] + arr[j] + arr[k];
                    if (tempSum == X) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
