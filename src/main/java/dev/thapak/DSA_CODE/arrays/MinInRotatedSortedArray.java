package dev.thapak.DSA_CODE.arrays;

public class MinInRotatedSortedArray {
    public static void main(String[] args) {
     int [] nums=new int[]{3,4,5,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }

    public static int findMin(int[] nums) {

        int left=0;
        int right=nums.length-1;
        int ans=nums[0];

        if(nums.length==0) return nums[0];


        while(left<=right){

            if(nums[left]<nums[right]){
                ans=Math.min(ans,nums[left]);
            }
            int mid=left+(right-left)/2;

            ans=Math.min(ans,nums[mid]);

            if(nums[left]<=nums[mid]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return ans;
    }

    public static int findMin1(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]) {
                // Minimum is in right half
                low = mid + 1;
            } else {
                // Minimum is in left half including mid
                high = mid;
            }
        }

        return nums[low];
    }

    public static int findMin2(int[] nums) {
        // Initialize low and high pointers
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {

            // Calculate mid index
            int mid = low + (high - low) / 2;

            // Check which half to discard
            if (nums[mid] > nums[high]) {

                // Minimum lies in right half
                low = mid + 1;

            } else {

                // Minimum lies in left half (including mid)
                high = mid;
            }
        }

        // Return the minimum element
        return nums[low];
    }

}
