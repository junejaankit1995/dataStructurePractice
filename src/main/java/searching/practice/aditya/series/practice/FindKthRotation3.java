package searching.practice.aditya.series.practice;

public class FindKthRotation3 {

    int findKRotation(int arr[], int n) {
        int lb = 0, up = n - 1;
        if (arr[lb] <= arr[up]) {
            return lb;
        }
        int mid = -1, prev, next, result = -1;
        while (lb <= up) {
            if (arr[lb] < arr[up]) {
                return lb;
            }
            mid = lb + ((up - lb) / 2);
            prev = (mid + n - 1) % n;
            next = (mid + 1) % n;
            if (arr[mid] < arr[prev] && arr[mid] < arr[next]) {
                return mid;
            }
            if (arr[lb] <= arr[mid]) {
                lb = mid + 1;
            } else {
                up = mid - 1;
            }
        }
        return mid;

    }

    public static void main(String[] args) {
        FindKthRotation3 objt = new FindKthRotation3();
        //int[] input = new int[]{66, 72, 79, 86, 95, 104, 106, 110, 119, 123, 124, 129, 132, 136, 137, 142, 150, 2, 12, 14, 17, 26, 30, 36, 38, 46, 52, 60};
        int[] input = new int[]{5, 1, 2, 3, 4};
        System.out.println(objt.findKRotation(input, input.length));
    }
}
