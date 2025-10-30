package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;

public class NextPermutations {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 5, 4, 3, 1};

        int[] nextPermutation = nextPermutation(nums);

        System.out.println(Arrays.toString(nextPermutation));


    }

    public static int[] nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n - 2;

        // Step 1: Find first decreasing element from right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If such element found, find next greater element & swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse from i+1 to end
        reverse(nums, i + 1, n - 1);

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }
}
