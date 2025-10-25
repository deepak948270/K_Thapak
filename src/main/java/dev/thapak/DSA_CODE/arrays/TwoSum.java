package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum1(nums, target);
        System.out.println(Arrays.toString(result));


    }

    /*brute force approach -> O(n2)
     * */
    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    /*optimal solution -> O(n)
     * */
    public static int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (hashMap.containsKey(diff)) {
                return new int[]{hashMap.get(diff), i};
            }
            hashMap.put(nums[i], i);
        }

        return null;

    }
}
