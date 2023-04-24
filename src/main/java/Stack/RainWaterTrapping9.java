package Stack;


//https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
public class RainWaterTrapping9 {

    /*
    Water store on each building depends upon
        1) Max Building from left
        2) Max Building from Right

        Min of above 2 - height of current building;

        Total store water will be
        Summation of water store in each building.
    */
    static long trappingWater(int arr[], int n) {
        long currentwater = 0, totalWater = 0;
        // Your code here
        int[] mxl = new int[n];
        int[] mxr = new int[n];
        //Intialize Maximum element from left
        mxl[0] = arr[0];
        for (int i = 1; i < n; i++) {
            mxl[i] = mxl[i - 1] > arr[i] ? mxl[i - 1] : arr[i];
        }
        //Intialize Maximum element from Right
        mxr[n - 1] = arr[n - 1];
        for (int i = n - 2; i > -1; i--) {
            mxr[i] = mxr[i + 1] > arr[i] ? mxr[i + 1] : arr[i];
        }
        //Water store in each building.
        for (int i = 0; i < n; i++) {
            currentwater = (long) (Math.min(mxl[i], mxr[i]) - arr[i]);
            totalWater += currentwater;
        }
        return totalWater;
    }
}

