package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;

public class RotateArrayByKSteps {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateArrayOptimized(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotateArrayOptimized(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    public static void rotateArray(int[] arr, int k) {
        // avoid un-necessary rotations
        k = k % arr.length;

        for (int i = 0; i < k; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

}
