package searching.practice;

public class PeakElement7 {

    /*public int peakElement(int[] arr, int n) {
        int result;
        if (n == 2) {
            return arr[0] > arr[1] ? 0 : 1;
        }
        result = binarySearch(arr, 0, n - 1);
        if (result == -1) {
            result = arr[n - 1] > arr[0] ? n - 1 : 0;
        }
        return result;
    }

    private int binarySearch(int[] arr, int lb, int up) {
        if (lb >= up) {
            return -1;
        }
        int mid = (lb + up) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return binarySearch(arr, mid + 1, up);
        } else {
            return binarySearch(arr, lb, mid - 1);
        }
    }*/
    public int peakElement(int[] arr, int n) {
        int max = arr[0];
        int maxIndex = 0;
        if(n <= 2) {
            for(int i = 0; i < n; i++) {
                if(arr[i] > max) {
                    maxIndex = i;
                    max = arr[i];
                }
            }
            return maxIndex;
        } else {
            return extendedBinarySerach(arr, 0, n-1);
        }
    }

    private int extendedBinarySerach(int[] arr, int lb, int up) {
        if(lb >= up) {
            return lb == up ? up : -1;
        }
        int mid = (lb + up)/ 2;
        if(arr[mid] > arr[mid - 1] && arr[mid + 1] < arr[mid]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return extendedBinarySerach(arr, mid+1, up);
        } else {
            return extendedBinarySerach(arr, lb, mid - 1);
        }
    }

    public static void main(String[] args) {
        PeakElement7 obj = new PeakElement7();
        //int[] input = new int[]{10, 20, 30, 40, 50, 40, 30, 20, 10};
        int[] input = new int[]{1, 13};
        System.out.println(obj.peakElement(input, input.length));
    }
}
