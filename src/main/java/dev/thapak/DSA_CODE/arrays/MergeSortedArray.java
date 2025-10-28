package dev.thapak.DSA_CODE.arrays;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int [] nums1=new int[]{1,2,3,0,0,0};
        int [] nums2=new int[]{2,5,6};
        int m=3;
        int n=3;

        int[] mergedArray = merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(mergedArray));
    }

    public  static int [] merge(int[] nums1, int m, int[] nums2, int n) {
        // pointers for nums1, nums2 and end of the merged array
        int p1=m-1;
        int p2=n-1;
        int i =m+n-1;

        // merge in reverse order
        while (p2>=0){
            if(p1>=0 && nums1[p1]>nums2[p2]){
                nums1[i]=nums1[p1];
                p1--;
            }else{
                nums1[i]=nums2[p2];
                p2--;
            }
            i--;
        }

        return nums1;
    }
}
