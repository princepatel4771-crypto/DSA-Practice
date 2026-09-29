import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort karo pehle
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; i++) {
            
            // Duplicate skip
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            for(int j = i + 1; j < nums.length - 2; j++) {
                
                // Duplicate skip
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                
                // Two pointer
                int left = j + 1;
                int right = nums.length - 1;
                
                while(left < right) {
                    long sum = (long)nums[i] + nums[j] + 
                               nums[left] + nums[right];
                    
                    if(sum == target) {
                        result.add(Arrays.asList(
                            nums[i], nums[j], nums[left], nums[right]));
                        
                        // Duplicate skip
                        while(left < right && 
                              nums[left] == nums[left+1]) left++;
                        while(left < right && 
                              nums[right] == nums[right-1]) right--;
                        
                        left++;
                        right--;
                    }
                    else if(sum < target) left++;
                    else right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.fourSum(
            new int[]{1,0,-1,0,-2,2}, 0));
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(sol.fourSum(
            new int[]{2,2,2,2,2}, 8));
        // [[2,2,2,2]]
    }
}