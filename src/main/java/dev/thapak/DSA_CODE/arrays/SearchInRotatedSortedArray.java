package dev.thapak.DSA_CODE.arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int [] nums=new int[]{5,4,0,1,2,3};

        int target=2;

        int searchIndex = search(nums, target);
        System.out.println(searchIndex);

    }

    public static int search(int[] nums, int target) {
        int left =0;
        int right =nums.length-1;

        while(left <= right ){
            int mid =left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[left]<=nums[mid]){
                // check target values fall outside
                if(target<nums[left] && target>nums[mid]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }else{
                if(target>nums[right] && target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }


        }

        return -1;
    }

    public static int search1(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        // if have only one element then directly return that element
        if(nums.length==0) return 0;


        // if have more than one element then we need to calculate it

        while(left<=right){
            // calculation of mid
            int mid =left+(right-left)/2;


            //if target is equal to the mid element then we found the match

            if(target == nums[mid])return mid;

            // check which half is sorted

            // left half sorted
            if(nums[left]<=nums[mid]){

                // check that target is lies within the sorted half or not

                // if yes then shrink the sorted part size
                if(target>=nums[left] && target<nums[mid]){
                    right=mid-1;
                }else{  // if not then move to the right sorted half
                    left=mid+1;
                }
            }
            else{       // right half sorted

                // check that target is lies within the sorted right half or not

                // if yes then shrink the sorted part size
                if(target > nums[mid] && target <= nums[right]){

                    left=mid+1;
                }
                else{
                    right=mid-1;
                }

            }
        }

        return -1;


    }



}
