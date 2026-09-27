import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        // Sort karo pehle
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Closest update karo
                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                
                if(sum < target) left++;
                else if(sum > target) right--;
                else return sum; // exact match!
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeSumClosest(
            new int[]{-1,2,1,-4}, 1)); // 2
        System.out.println(sol.threeSumClosest(
            new int[]{0,0,0}, 1));     // 0
    }
}