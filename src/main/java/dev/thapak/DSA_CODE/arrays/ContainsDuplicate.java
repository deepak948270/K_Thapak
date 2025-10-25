package dev.thapak.DSA_CODE.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {

        int [] nums=new int[]{1,2,3,1};
        boolean containsDuplicate = containsDuplicate(nums);
        System.out.println(containsDuplicate);

    }

    /*approach-1: using the HashSet
    * */
    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (hashSet.contains(nums[i])) {

                return true;
            } else {
                hashSet.add(nums[i]);
            }
        }

        return false;
    }

    /*approach-2: using the HashMap*/
    public static boolean containsDuplicate1(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(nums[i])) {

                return true;
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        return false;
    }
}
