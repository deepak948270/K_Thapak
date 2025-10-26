package dev.thapak.DSA_CODE.arrays;

public class MaxSubArrayKadanesAlgo {
    public static void main(String[] args) {
        int [] nums=new int []{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSumofSubArray = maxSubArray(nums);
        System.out.println(maxSumofSubArray);
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
