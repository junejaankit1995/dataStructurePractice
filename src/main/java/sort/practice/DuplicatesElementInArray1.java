package sort.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class DuplicatesElementInArray1 {

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        int j;
        ArrayList<Integer> result = new ArrayList<>();
        if (n <= 1) {
            result.add(-1);
            return result;
        }
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; ) {
            j = i + 1;
            while (j < n && arr[i] == arr[j]) {
                j++;
            }
            if (i + 1 != j) {
                result.add(arr[i]);
            }
            i = j;
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}
