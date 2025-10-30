package dev.thapak.DSA_CODE.arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxAreaWithBruteForceApproach(arr);
        System.out.println(maxArea);

    }

    public static int maxArea(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        // need to return the max area of the container which forms with two lines which hold most water
        int maxArea = 0;

        while (i < j) {

            int length = Math.min(arr[i], arr[j]);

            int width = (j - i);

            int currentArea = length * width;

            maxArea = Math.max(currentArea, maxArea);

            if (arr[i] < arr[j]) {
                i++;
            } else {

                // we decrement the counter of j as the arr[j]<arr[i], also if arr[j]==arr[i] then we move any counter , here we move j counter
                j--;
            }
        }
        return maxArea;

    }

    public static int maxAreaWithBruteForceApproach(int[] arr) {

        int maxArea = 0;

        if (arr.length < 2) return -1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int height = Math.min(arr[i], arr[j]);
                int width = j - 1;

                int currentArea = height * width;

                maxArea = Math.max(currentArea, maxArea);
            }
        }

        return maxArea;
    }
}
