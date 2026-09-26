import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // Sort karo pehle
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2; i++) {
            
            // Duplicate skip karo
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            // Two pointer
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if(sum == 0) {
                    // Answer mila!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Duplicates skip karo
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    
                    left++;
                    right--;
                }
                else if(sum < 0) left++;  // sum chota hai
                else right--;             // sum bada hai
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeSum(
            new int[]{-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(sol.threeSum(
            new int[]{0,0,0}));           // [[0,0,0]]
    }
}