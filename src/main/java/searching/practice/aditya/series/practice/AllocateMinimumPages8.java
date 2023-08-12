package searching.practice.aditya.series.practice;

public class AllocateMinimumPages8 {

    public static int findPages(int[] arr, int N, int M) {
        int result = -1;
        int maxPage = 0, totalPages = 0;
        int mid, lb, up;
        //Number of students greater than book
        if (M > N) {
            return result;
        }
        for (int i = 0; i < N; i++) {
            maxPage = arr[i] > maxPage ? arr[i] : maxPage;
            totalPages += arr[i];
        }
        lb = maxPage;
        up = totalPages;
        while (lb <= up) {
            mid = lb + (up - lb) / 2;
            if (isValid(arr, N, mid, M)) {
                result = mid;
                up = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        return result;

    }

    public static boolean isValid(int[] arr, int n, int mid, int s) {
        int students = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > mid) {
                students++;
                sum = arr[i];
            }
            if (students >= s) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {15, 17, 20};
        System.out.println(AllocateMinimumPages8.findPages(input, input.length, 2));
    }
}
