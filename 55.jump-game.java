class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            // Agar current index tak pahunch hi nahi sakte
            if(i > maxReach)
                return false;
            
            // Sabse door kahan tak pahunch sakte hain, update karo
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Last index tak pahunch gaye
            if(maxReach >= nums.length - 1)
                return true;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.canJump(
            new int[]{2,3,1,1,4})); // true
        System.out.println(sol.canJump(
            new int[]{3,2,1,0,4})); // false
        System.out.println(sol.canJump(
            new int[]{0}));          // true
    }
}