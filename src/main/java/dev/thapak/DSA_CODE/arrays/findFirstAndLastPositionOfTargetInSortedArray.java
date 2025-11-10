package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;

public class findFirstAndLastPositionOfTargetInSortedArray {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] firstAndLastPosition = findFirstAndLastPosition(nums, target);
        System.out.println(Arrays.toString(firstAndLastPosition));

    }

    private static int[] findFirstAndLastPosition(int[] nums, int target) {
        int first = findBound(nums, target, true);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findBound(nums, target, false);

        return new int[]{first, last};
    }

    public static int findBound(int[] nums, int target, boolean isFirst) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                if (isFirst) {

                    if (mid == start || nums[mid - 1] != target) {
                        return mid;
                    }

                    end = mid - 1;

                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    start = mid + 1;
                }


            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;

    }
}


