package dev.thapak.DSA_CODE.arrays;

import java.util.HashMap;

public class ContainsDuplicateII {
    public static void main(String[] args) {

        int [] nums=new int[]{1,2,3,1,2,3};
        int k=2;
        boolean containsNearbyDuplicate = containsNearbyDuplicate(nums, k);
        System.out.println(containsNearbyDuplicate);
    }


    /*
    * optimal solution -> O(n)*/
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])&& Math.abs(i-hashMap.get(nums[i]))<=k)
            {

                return true;
            }
            else{
                hashMap.put(nums[i],i);
            }
        }

        return false;

    }


    /*
    * brute force approach O(n2)-> getting Time Limit Exceeded exception */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j] && Math.abs(i-j)<=k){
                    return true;
                }
            }
        }

        return false;

    }
}
