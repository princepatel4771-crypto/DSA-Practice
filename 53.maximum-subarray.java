class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0];
        int currSum = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            // Pehle se continue karein ya naya shuru karein?
            currSum = Math.max(nums[i], currSum + nums[i]);
            
            // Max update karo
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.maxSubArray(
            new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(sol.maxSubArray(
            new int[]{1}));                       // 1
        System.out.println(sol.maxSubArray(
            new int[]{5,4,-1,7,8}));              // 23
    }
}