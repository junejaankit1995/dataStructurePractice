package searching;

import java.util.HashMap;

public class FirstRepeatedValue1 {

    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int indexTemp = -2;
        int temp;
        for (int i = n - 1; i >= 0; i--) {
            temp = map.getOrDefault(arr[i], 0) + 1;
            if (temp > 1) {
                indexTemp = i;
            }
            map.put(arr[i], temp);
        }
        return indexTemp + 1;
    }
}
