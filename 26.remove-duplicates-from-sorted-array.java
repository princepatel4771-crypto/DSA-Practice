class Solution {
    public int removeDuplicates(int[] nums) {
        
        // Pehla element toh hamesha unique hoga
        int k = 1;
        
        // Dusre element se shuru karo
        for(int i = 1; i < nums.length; i++) {
            
            // Agar pehle wale se alag hai
            if(nums[i] != nums[i-1]) {
                nums[k] = nums[i]; // unique jagah pe daalo
                k++; // aage badho
            }
        }
        
        // Kitne unique hain return karo
        return k;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates(
            new int[]{1,1,2}));        // 2
        System.out.println(sol.removeDuplicates(
            new int[]{0,0,1,1,1,2,2,3,3,4})); // 5
    }
}