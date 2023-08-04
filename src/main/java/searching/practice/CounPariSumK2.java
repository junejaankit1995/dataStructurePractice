package searching.practice;


import java.util.HashMap;

public class CounPariSumK2 {

    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int reqVal, count = 0;
        for (int i = 0; i < n; i++) {
            reqVal = k - arr[i];
            if (map.get(reqVal) != null) {
                count += map.get(reqVal);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return count;
    }
}
