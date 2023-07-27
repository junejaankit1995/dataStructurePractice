package sort;

public interface Sort {
    void sort(int[] arr, int n);

    default void swap(int[] input, int srcIndex, int dstIndex) {
        int temp = input[srcIndex];
        input[srcIndex] = input[dstIndex];
        input[dstIndex] = temp;
    }
}
