package dev.thapak.DSA_CODE.arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {

        int [] nums1=new int[]{1,3};
        int [] nums2=new int[]{2};

        double median = findMedianSortedArraysWithOptimalApproach(nums1, nums2);
        System.out.println(median);

    }

    public static double findMedianSortedArraysWithOptimalApproach(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for optimization
        // because we are processing the array having the smaller length
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysWithOptimalApproach(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        int halfLength = (totalLength + 1) / 2; // adding +1 because handling both even and odd length

        int left = 0;
        int right = m; // because there are m+1 partitions are possible

        while (left <= right) {
            // Partition nums1
            int partition1 = (left + right) / 2;
            // Partition nums2 (we take remaining elements to make half)
            int partition2 = halfLength - partition1;

            // Find boundary elements
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Correct partition found
                if (totalLength % 2 == 0) {
                    // Even total length: median is average of two middle elements
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // Odd total length: median is the middle element
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // We're too far right in nums1, move left
                right = partition1 - 1;
            } else {
                // We're too far left in nums1, move right
                left = partition1 + 1;
            }
        }

        return 0.0;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double medianOfTwoSortedArray=0.0;
        //step-1: merge two sorted Arrays in to single Sorted Array
        int [] mergedSortedArray= mergeSortedArrays(nums1,nums2);

        // step-2: calculate median of the two sorted array by considering both even and odd length condtions

        if(mergedSortedArray.length==0) return 0;

        // for odd length condition
        if(mergedSortedArray.length%2!=0){

            medianOfTwoSortedArray=mergedSortedArray[(mergedSortedArray.length-1)/2];

        }else{ // for even length condition

            medianOfTwoSortedArray=(mergedSortedArray[(mergedSortedArray.length-1)/2]+mergedSortedArray[(mergedSortedArray.length / 2)])/2.0;


        }

        return medianOfTwoSortedArray;


    }

    public static int [] mergeSortedArrays(int [] nums1,int [] nums2){
        int [] ansArr=new int [(nums1.length)+(nums2.length)];

        int p1=nums1.length-1;
        int p2=nums2.length-1;
        int ansArrIndex=(nums1.length)+(nums2.length)-1;

        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                ansArr[ansArrIndex]=nums1[p1];
                p1--;
            }else{
                ansArr[ansArrIndex]=nums2[p2];
                p2--;
            }
            ansArrIndex--;
        }

        // Copy remaining elements
        while (p1 >= 0) {
            ansArr[ansArrIndex] = nums1[p1];
            p1--;
            ansArrIndex--;
        }

        while (p2 >= 0) {
            ansArr[ansArrIndex] = nums2[p2];
            p2--;
            ansArrIndex--;
        }

        return ansArr;
    }

    public static int [] mergeSortedArrays1(int [] nums1,int [] nums2){
        int total = nums1.length + nums2.length;
        int midIndex = total / 2; // stop once we fill middle index

        int[] ansArr = new int[total];
        int p1 = nums1.length - 1;
        int p2 = nums2.length - 1;
        int ansArrIndex = total - 1;

        while(p1 >= 0 && p2 >= 0 && ansArrIndex >= midIndex){
            if(nums1[p1] > nums2[p2]){
                ansArr[ansArrIndex] = nums1[p1];
                p1--;
            } else {
                ansArr[ansArrIndex] = nums2[p2];
                p2--;
            }
            ansArrIndex--;
        }

        while(p1 >= 0 && ansArrIndex >= midIndex){
            ansArr[ansArrIndex] = nums1[p1];
            p1--;
            ansArrIndex--;
        }

        while(p2 >= 0 && ansArrIndex >= midIndex){
            ansArr[ansArrIndex] = nums2[p2];
            p2--;
            ansArrIndex--;
        }

        return ansArr;
    }
}
