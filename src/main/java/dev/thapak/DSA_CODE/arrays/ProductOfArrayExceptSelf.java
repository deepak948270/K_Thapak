package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int [] nums=new int[]{1,2,3,4};
        int [] nums1=new int[] {-1,1,0,-3,3};
        int[] productArrExceptSelf = productExceptSelf1(nums1);
        System.out.println(Arrays.toString(productArrExceptSelf));
    }

    public static int[] productExceptSelf(int[] nums) {

        int [] result =new int [nums.length];
        Arrays.fill(result,1);

        int pre=1;
        int post=1;

        for(int i=0;i<nums.length;i++){
            result[i]=pre;
            pre=nums[i]*pre;
        }

        for(int i=nums.length-1;i>=0;i--){
            result[i]=result[i]*post;
            post=post*nums[i];
        }


        return result;
    }

    public static int[] productExceptSelf1(int[] nums) {

        int [] resultArr=new int [nums.length];

        int prefix=1;
        int suffix=1;

        for(int i=0;i<nums.length;i++){
            resultArr[i]=prefix;
            prefix=nums[i]*prefix;
        }


        for(int i=nums.length-1;i>=0;i--){
            resultArr[i]=suffix*resultArr[i];
            suffix=suffix*nums[i];
        }

        return resultArr;
    }
}
