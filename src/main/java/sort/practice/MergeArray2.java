package sort.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeArray2 {

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
        int[] marr = new int[k * k];
        int midx = 0;
        ArrayList<Integer> result = new ArrayList<>();
        //converting 2 dimensional array to 1 dimensional
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; ) {
                marr[midx++] = arr[i][j++];
            }
        }
        Arrays.sort(marr);
        Arrays.stream(marr).forEach(result::add);
        return result;
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        mergeKArrays(input, 3);
    }
}
