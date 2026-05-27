package com.mk.java.binarysearch;

public class BS {
    public static void main(String[] args) {
        int[] ar = {3, 4, 5, 1, 2};
        int[] ar1 = {2,1};
        int[] ar3 = {7,0,1,2,3,4,5};
        int[] ar2 = {4,5,6,7,0,1,2};
        System.out.println("findMind " + findMin2(ar2));
    }


    private static int findMind(int[] ar) {
        int lo = 0;
        int hi = ar.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (ar[mid] > ar[lo]) //3,4,5,1,2
            {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;

    }

    private static int findMin2(int[] ar) {
        int lo = 0;
        int hi = ar.length - 1;
        int n = ar.length;

        while (lo <= hi) {

            // important optimization
            if (ar[lo] <= ar[hi]) return lo;

            int mid = lo + (hi - lo) / 2;

            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            // correct pivot condition
            if (ar[mid] <= ar[prev] && ar[mid] <= ar[next])
                return mid;

            // correct direction logic
            if (ar[mid] >= ar[lo]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    private static int findMin(int[] ar) {
        int lo = 0;
        int hi = ar.length - 1; // 4,5,6,7,0,1,2
        int n = ar.length;  // 7,0,1,2,3,4,5

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            //if (ar[lo] <= ar[hi]) return lo;
            if (ar[prev] >= ar[mid] && ar[next] >= ar[mid])
                return mid;
            else if (ar[lo] <=ar[mid] )
                lo = mid + 1;
            else
                hi = mid-1;
        }

        return -1;
    }
}
