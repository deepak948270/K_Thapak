package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

      int [] nums=new int[]{100,4,200,1,3,2};
        int longestConsecutiveSequence = longestConsecutive3(nums);
        System.out.println(longestConsecutiveSequence);

    }

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : nums) {
            hashSet.add(value);
        }

        int lcs = 0; // longest consecutive sequence length

        for (int i = 0; i < nums.length; i++) {
            // check if it's the start of a sequence
            if (!hashSet.contains(nums[i] - 1)) {
                int currentNum = nums[i];
                int ccs = 1; // current consecutive sequence length

                // count forward
                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    ccs++;
                }

                lcs = Math.max(lcs, ccs);
            }
        }

        return lcs;
    }

    public static int longestConsecutive1(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        Arrays.sort(nums);

        int lcs = 1;  // longest consecutive sequence
        int ccs = 1;  // current consecutive sequence count

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // skip duplicate numbers
                continue;
            } else if (nums[i] - nums[i - 1] == 1) {
                // consecutive numbers
                ccs++;
            } else {
                // not consecutive → reset counter
                ccs = 1;
            }

            lcs = Math.max(lcs, ccs);
        }

        return lcs;
    }

    public static int longestConsecutive2(int[] nums) {

        if (nums.length == 0) return 0;

        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : nums) {
            hashSet.add(value);
        }

        int lcs = 0;

        for (int num : hashSet) {
            // check if it's the start of a sequence
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int ccs = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    ccs++;
                }

                lcs = Math.max(lcs, ccs);
            }
        }

        return lcs;
    }

    public static int longestConsecutive3(int [] nums){
        if(nums.length ==0){
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            numSet.add(nums[i]);
        }

        int longestSub = 1;

        for(int num:numSet){
            if(numSet.contains(num-1)){
                continue;
            }
            else{
                int currentNum = num;
                int currentSub = 1;
                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }

                longestSub = Math.max(longestSub, currentSub);
            }


        }
        return longestSub;
    }
}
