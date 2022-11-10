package org.example.recursion.ibh;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class UniqueSubsets {

    public static ArrayList <ArrayList<Integer>> allSubsets(int[] arr, int n) {
        Map<String, ArrayList<Integer>> result = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        solve(arr, n, 0, output, result);
        return new ArrayList<>(result.values());
    }

    private static void solve(int[] arr, int len, int index,
                              ArrayList<Integer> output, Map<String, ArrayList<Integer>> cont) {
        if(len == index) {
                cont.putIfAbsent(output.toString(), output);
            return;
        }

        solve(arr, len, index + 1, output, cont);
        ArrayList<Integer> newOutput = new ArrayList<>(output);
        newOutput.add(arr[index]);
        solve(arr, len, index + 1, newOutput, cont);
    }

    public static void main(String[] args) {
        System.out.println(UniqueSubsets.allSubsets(new int[] {2, 1, 2}, 3));
    }
}
