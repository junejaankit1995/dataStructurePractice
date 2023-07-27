package sort;

public class ShellSortOld {

    public void shellSort(int[] arr, int n) {
        for (int gap = n / 2; gap >= 1; gap /= 2) {
            for (int i = 0, j = gap; j < n; ) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    for (int ip = i - gap; ip >= 0 && arr[ip] > arr[ip + gap]; ip -= gap) {
                        swap(arr, ip, ip + gap);
                    }
                }
                i++;
                j++;
            }
        }
    }

    private void swap(int[] input, int sIndex, int dIndex) {
        int temp = input[sIndex];
        input[sIndex] = input[dIndex];
        input[dIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        ShellSortOld obj = new ShellSortOld();
        obj.shellSort(arr, arr.length);
        System.out.println(arr);
    }
}
