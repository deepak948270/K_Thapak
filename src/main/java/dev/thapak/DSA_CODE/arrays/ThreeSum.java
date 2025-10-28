package dev.thapak.DSA_CODE.arrays;
import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int [] nums=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSumUsingTwoPointers(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSumUsingTwoSumApproach(int[] nums) {

        Set<List<Integer>> resultSet=new HashSet<>();

        // sort the nums array to remove duplicates
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue ;

            HashSet<Integer> hashSet =new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int k=-(nums[i]+nums[j]);
                if(hashSet.contains(k)){
                    // Sort the triplet to maintain uniqueness
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(triplet);

                    resultSet.add(triplet);

                }

                hashSet.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet);
    }

    public static List<List<Integer>> threeSumUsingTwoPointers(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // Step 2: Iterate through each number
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Use two-pointer technique (same approach as we did in the two sum 2 )
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
