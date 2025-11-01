package dev.thapak.DSA_CODE.arrays;

public class TrappingRainWater {
    public static void main(String[] args) {

        int [] height=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedWater = trap(height);
        System.out.println(trappedWater);

    }

    public int trap2(int[] arr) {

        int [] leftMaxArr=new int [arr.length];
        int [] rightMaxArr=new int [arr.length];

        int trappedWater=0;

        int leftMax=arr[0];
        int rightMax=arr[arr.length-1];


        if(arr.length==0) return 0;

        for(int i=0;i<arr.length;i++){

            leftMax=Math.max(leftMax,arr[i]);

            leftMaxArr[i]=leftMax;
        }

        for(int i=arr.length-1;i>0;i--){
            rightMax=Math.max(rightMax,arr[i]);

            rightMaxArr[i]=rightMax;
        }


        // loop to calculate the trapped water

        for(int i=0;i<arr.length;i++){

            // trapped water -> min of (leftMax, rightMax)-current element height

            if(Math.min(leftMaxArr[i],rightMaxArr[i])-arr[i]>0){

                trappedWater= trappedWater+Math.min(leftMaxArr[i],rightMaxArr[i])-arr[i];

            }
        }

        return trappedWater;

    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int total = 0;
        int leftMax = height[0];
        int rightMax = height[right];

        while(left<right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                if(leftMax-height[left] >0){
                    total=total+leftMax-height[left];
                }
                left++;
            }
            else{
                rightMax = Math.max(rightMax,height[right]);
                if(rightMax - height[right] > 0){
                    total = total+rightMax-height[right];
                }
                right--;
            }
        }
        return total;
    }

    public static int trap1(int [] arr){
        int left=0; int right=arr.length-1;
        int leftMax=arr[0];
        int rightMax=arr[arr.length-1];

        int trappedWater=0;

        while(left<right){
            if(arr[left]<arr[right]){

                // update leftMax ,if current max is found
                leftMax=Math.max(leftMax,arr[left]);

                // update the trapped water
                trappedWater=trappedWater+leftMax-arr[left];

                // increment left counter
                left++;
            }else{

                // update the rightMax, if current max is found
                rightMax=Math.max(rightMax,arr[right]);

                // update the trapped water
                trappedWater=trappedWater+rightMax-arr[right];

                // decrement right counter
                right--;

            }
        }

        return trappedWater;
    }
}
