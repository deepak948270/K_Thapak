package dev.thapak.DSA_CODE.arrays;

public class MaxProductSubArrayKadanesAlgo {
    public static void main(String[] args) {

        int [] nums=new int[]{2,3,-2,4};

        int maxProductOfSubArray = maxProduct(nums);
        System.out.println(maxProductOfSubArray);
    }

    public static int maxProduct(int[] nums) {

        int minProduct=nums[0];
        int maxProduct=nums[0];
        int result=nums[0];


        for(int i=1;i<nums.length;i++){
            // handling the edge case
            if(nums.length==0) return 0;

            int current=nums[i];

            // temp is used to preserve the new max value while we still need the old max value for the min calculation.
            int temp=Math.max(current,Math.max(current*maxProduct,current*minProduct));

            minProduct=Math.min(current,Math.min(current*minProduct,current*maxProduct));

            maxProduct=temp;

            result=Math.max(result,maxProduct);


        }

        return result;

    }
}
