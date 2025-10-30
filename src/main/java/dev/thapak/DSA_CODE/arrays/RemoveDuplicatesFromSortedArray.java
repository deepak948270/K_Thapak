package dev.thapak.DSA_CODE.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {

        int [] nums= new int[]{0,0,1,1,1,2,2,3,3,4};

        int countOfUniqueNumbers = removeDuplicates(nums);
        System.out.println(countOfUniqueNumbers);
    }

    public static int removeDuplicates(int[] nums) {

        int uniqueNumberIndex = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[uniqueNumberIndex] = nums[i];
                uniqueNumberIndex++;
            }
        }

        return uniqueNumberIndex;

    }
}
