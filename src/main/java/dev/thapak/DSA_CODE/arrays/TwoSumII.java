package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] twoSumArr = twoSum(numbers, target);

        System.out.println(Arrays.toString(twoSumArr));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // adding +1 to the index as the question said that the indexing starts from the 1 instead of the 0
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};

    }
}
